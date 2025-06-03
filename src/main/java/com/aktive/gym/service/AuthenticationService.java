package com.aktive.gym.service;


import com.aktive.gym.dto.FitnessAndBodyInfoDto;
import com.aktive.gym.dto.LoginDto;
import com.aktive.gym.dto.RegisterUserDto;
import com.aktive.gym.dto.UserDto;
import com.aktive.gym.model.FitnessAndBodyInfo;
import com.aktive.gym.model.User;
import com.aktive.gym.repo.UserRepository;
import com.aktive.gym.util.constants.CommonConstants;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto signup(RegisterUserDto input) throws BadRequestException {
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

        FitnessAndBodyInfoDto fitnessAndBodyInfo = input.getFitnessAndBodyInfo();
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

        return UserDto.builder()
                .email(registeredUser.getEmail())
                .fullName(registeredUser.getFullName())
                .membershipId(registeredUser.getMembershipId())
                .membershipPlan(registeredUser.getMembershipPlan())
                .createdAt(registeredUser.getCreatedAt())
                .updatedAt(registeredUser.getUpdatedAt())
                .build();
    }

    public User authenticate(LoginDto input) {
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
            int id = new Random().nextInt(90000);
            membershipId = String.valueOf(id);
            canUseMemebershipId = !userRepository.existsByMembershipId(membershipId);
        }
        return membershipId;
    }


}
