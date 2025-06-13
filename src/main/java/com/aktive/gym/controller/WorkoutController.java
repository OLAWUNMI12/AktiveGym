package com.aktive.gym.controller;


import com.aktive.gym.service.WorkoutService;
import com.aktive.gym.util.constants.CommonConstants;
import com.aktive.gym.validator.ValidEnum;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/user/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PutMapping()
    public ResponseEntity<Object> computeWorkoutProgress( @RequestParam String exercise,
                                                          @RequestParam Boolean flag) throws BadRequestException {

        if(StringUtils.isBlank(exercise)){
            throw new BadRequestException("Exercise is required");
        }

        CommonConstants.Excercises excercises;
        try {
            excercises = CommonConstants.Excercises.valueOf(exercise.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid exercise");
        }
        return ResponseEntity.ok().body(workoutService.computeFullBodyWorkout(excercises, flag));
    }



    @GetMapping()
    public ResponseEntity<Object> getWorkoutPlan( @ValidEnum (enumClass = CommonConstants.WorkoutPlan.class) @RequestParam String type){

        return ResponseEntity.ok().body(workoutService.getWorkoutPlan(type));
    }


}
