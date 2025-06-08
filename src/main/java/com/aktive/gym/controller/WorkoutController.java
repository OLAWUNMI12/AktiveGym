package com.aktive.gym.controller;


import com.aktive.gym.service.WorkoutService;
import com.aktive.gym.util.constants.CommonConstants;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/user/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PutMapping()
    public ResponseEntity<Object> computeWorkoutProgress( @RequestParam String exercise,
                                                          @RequestParam Boolean flag) throws BadRequestException {

        CommonConstants.Excercises excercises;
        try {
            excercises = CommonConstants.Excercises.valueOf(exercise.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid exercise");
        }
        return ResponseEntity.ok().body(workoutService.computeFullBodyWorkout(excercises, flag));
    }


}
