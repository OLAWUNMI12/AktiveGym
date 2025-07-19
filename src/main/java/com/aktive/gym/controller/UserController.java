package com.aktive.gym.controller;


import com.aktive.gym.dto.UserDto;
import com.aktive.gym.dto.request.GetUsersRequest;
import com.aktive.gym.dto.request.UserEmailRequest;
import com.aktive.gym.dto.response.UserResponse;
import com.aktive.gym.model.User;
import com.aktive.gym.repo.UserRepository;
import com.aktive.gym.service.UserService;
import com.aktive.gym.service.pagination.CustomPage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/profile")
    public UserDto getUserprofile(){
        User registeredUser = userService.getCurrentUser();
        User user = userRepository.findByEmail(registeredUser.getEmail()).orElse(null);
        return UserDto.builder()
                .email(registeredUser.getEmail())
                .fullName(registeredUser.getFullName())
                .membershipId(registeredUser.getMembershipId())
                .membershipPlan(registeredUser.getMembershipPlan())
                .gender(user.getGender())
                .userRole(user.getUserRole())
                .age(user.getAge())
                .weight(user.getFitnessAndBodyInfo().getWeight())
                .height(user.getFitnessAndBodyInfo().getHeight())
                .fitnessGoal(user.getFitnessAndBodyInfo().getFitnessGoal())
                .dietaryPreference(user.getFitnessAndBodyInfo().getDietaryPreference())
                .trainer(user.getTrainer())
                .createdAt(registeredUser.getCreatedAt())
                .updatedAt(registeredUser.getUpdatedAt())
                .build();
    }


    @GetMapping
    public ResponseEntity<CustomPage<UserResponse>> getUsers(GetUsersRequest getTrainerRequest){
        return ResponseEntity.ok().body(userService.getUsers(getTrainerRequest));
    }


    @PostMapping("/send-email")
    public ResponseEntity<?> sendUserCustomEmail(@RequestBody UserEmailRequest userEmailRequest){
        userService.sendUserCustomEmail(userEmailRequest);
        return ResponseEntity.ok().build();
    }
}
