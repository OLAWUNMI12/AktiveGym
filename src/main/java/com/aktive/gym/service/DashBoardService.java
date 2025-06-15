package com.aktive.gym.service;


import com.aktive.gym.dto.response.UserDashboardResponse;
import com.aktive.gym.model.FitnessAndBodyInfo;
import com.aktive.gym.model.User;
import com.aktive.gym.model.UserExercises;
import com.aktive.gym.repo.UserExerciseRepository;
import com.aktive.gym.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DashBoardService {

    private final UserExerciseRepository userExerciseRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public UserDashboardResponse getUserDashboard(){
        User registeredUser = userService.getCurrentUser();
        User user = userRepository.findByEmail(registeredUser.getEmail()).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Optional<UserExercises> userExercises = userExerciseRepository.findByUsername(user.getUsername());
        Integer workoutProgress = 0;
        Double caloriesBurned = 0.0;
        if(userExercises.isPresent()){
            workoutProgress = userExercises.get().getWorkoutProgress();
            caloriesBurned = userExercises.get().getCaloriesBurned();
        }
        FitnessAndBodyInfo fitnessAndBodyInfo = user.getFitnessAndBodyInfo();

        return UserDashboardResponse.builder()
                .username(user.getUsername())
                .workoutProgress(workoutProgress)
                .weight(fitnessAndBodyInfo.getWeight())
                .bmi(fitnessAndBodyInfo.getBmi())
                .caloriesBurned(caloriesBurned)
                .build();
    }

}
