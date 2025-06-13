package com.aktive.gym.dto.request;


import com.aktive.gym.util.constants.CommonConstants;
import com.aktive.gym.validator.ValidEnum;
import com.aktive.gym.validator.ValidFitnessGoal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FitnessAndBodyInfoRequest {

    @NotNull(message = "Weight is mandatory")
    private Double weight;

    @NotNull(message = "Height is mandatory")
    private Double height;

    @NotEmpty(message = "Fitness goal is mandatory")
    @ValidFitnessGoal
    private List<String> fitnessGoal;

    @ValidEnum(enumClass = CommonConstants.DietaryPreference.class)
    @NotBlank(message = "Dietary preference is mandatory")
    private String dietaryPreference;
}
