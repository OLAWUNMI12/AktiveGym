package com.aktive.gym.service;


import com.aktive.gym.dto.request.FitnessAndBodyInfoRequest;
import com.aktive.gym.dto.request.LoginRequest;
import com.aktive.gym.dto.request.RegisterUserRequest;
import com.aktive.gym.dto.UserDto;
import com.aktive.gym.model.FitnessAndBodyInfo;
import com.aktive.gym.model.User;
import com.aktive.gym.repo.UserRepository;
import com.aktive.gym.util.constants.CommonConstants;
import jakarta.mail.MessagingException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final EmailService emailService;

    @Value("${login.url}")
    private String loginUrl;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            EmailService emailService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public UserDto signup(RegisterUserRequest input) throws BadRequestException {
        if (userRepository.findByEmail(input.getEmail()).isPresent()) {
            throw new BadRequestException("email already taken");
        }

        if (!input.getPassword().trim().equals(input.getConfirmPassword().trim())) {
            throw new BadRequestException("Passwords do not match");
        }

        User user = User.builder()
                .fullName(input.getFullName())
                .email(input.getEmail())
                .gender(CommonConstants.Gender.valueOf(input.getGender()))
                .age(input.getAge())
                .membershipPlan(CommonConstants.MembershipPlan.valueOf(input.getMembershipPlan()))
                .membershipId(generateMembershipId())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        FitnessAndBodyInfoRequest fitnessAndBodyInfo = input.getFitnessAndBodyInfo();
        double bmi = fitnessAndBodyInfo.getWeight() / (Math.pow(fitnessAndBodyInfo.getHeight(), 2));
        bmi = (double) Math.round(bmi * 100) / 100;
        FitnessAndBodyInfo fitnessAndBodyInfoEntity = FitnessAndBodyInfo.builder()
                .weight(fitnessAndBodyInfo.getWeight())
                .height(fitnessAndBodyInfo.getHeight())
                .bmi(bmi)
                .fitnessGoal(String.join(",", fitnessAndBodyInfo.getFitnessGoal()))
                .dietaryPreference(CommonConstants.DietaryPreference.valueOf(fitnessAndBodyInfo.getDietaryPreference()))
                .build();
        user.setFitnessAndBodyInfo(fitnessAndBodyInfoEntity);

        User registeredUser = userRepository.save(user);

        sendWelcomeEmail(registeredUser);

        return UserDto.builder()
                .email(registeredUser.getEmail())
                .fullName(registeredUser.getFullName())
                .membershipId(registeredUser.getMembershipId())
                .membershipPlan(registeredUser.getMembershipPlan())
                .createdAt(registeredUser.getCreatedAt())
                .updatedAt(registeredUser.getUpdatedAt())
                .build();
    }

    public User authenticate(LoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    public  String generateMembershipId() {
        boolean canUseMemebershipId = false;
        String membershipId = "";

        while (!canUseMemebershipId) {
            int id = new Random().nextInt(99999);
            membershipId = String.valueOf(id);
            canUseMemebershipId = !userRepository.existsByMembershipId(membershipId);
        }
        return "AKG" +  membershipId;
    }

    private void sendWelcomeEmail(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("fullName", user.getFullName());
        params.put("membershipId", user.getMembershipId());
        params.put("loginUrl", loginUrl);

        try {
            emailService.sendMail(user.getEmail(), "Welcome to AktiveGym", params, "welcome");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
