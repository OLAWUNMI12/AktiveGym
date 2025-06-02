package com.aktive.gym.service;


import com.aktive.gym.dto.LoginDto;
import com.aktive.gym.dto.RegisterUserDto;
import com.aktive.gym.dto.UserDto;
import com.aktive.gym.model.User;
import com.aktive.gym.repo.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        User user = User.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
        User registeredUser = userRepository.save(user);

        return UserDto.builder()
                .email(registeredUser.getEmail())
                .firstName(registeredUser.getFirstName())
                .lastName(registeredUser.getLastName())
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


}
