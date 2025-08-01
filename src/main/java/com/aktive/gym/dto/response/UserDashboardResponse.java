package com.aktive.gym.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDashboardResponse {

    private String username;
    private Integer workoutProgress;
    private Double weight;
    private Double bmi;
    private Double caloriesBurned;

}
