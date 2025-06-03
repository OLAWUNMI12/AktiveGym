package com.aktive.gym.dto;

import com.aktive.gym.util.constants.CommonConstants;
import com.aktive.gym.validator.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @NotBlank(message = "Full is mandatory")
    private String fullName;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @ValidEnum(enumClass = CommonConstants.Gender.class)
    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotNull(message = "Gender is mandatory")
    private Long age;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Confirm password is mandatory")
    private String confirmPassword;

    @ValidEnum(enumClass = CommonConstants.MembershipPlan.class)
    @NotBlank(message = "Membership plan is mandatory")
    private String membershipPlan;

    @Valid
    private FitnessAndBodyInfoDto fitnessAndBodyInfo;

}
