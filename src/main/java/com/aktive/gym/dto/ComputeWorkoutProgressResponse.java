package com.aktive.gym.dto;

import com.aktive.gym.util.constants.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComputeWorkoutProgressResponse {

    private Integer workoutProgress;
    private CommonConstants.Excercises exercise;
    private Boolean flag;
}
