package com.aktive.gym.controller;


import com.aktive.gym.dto.UserDto;
import com.aktive.gym.model.User;
import com.aktive.gym.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public UserDto getUserprofile(){
        User registeredUser = userService.getCurrentUser();
        return UserDto.builder()
                .email(registeredUser.getEmail())
                .fullName(registeredUser.getFullName())
                .membershipId(registeredUser.getMembershipId())
                .membershipPlan(registeredUser.getMembershipPlan())
                .createdAt(registeredUser.getCreatedAt())
                .updatedAt(registeredUser.getUpdatedAt())
                .build();
    }
}
