package com.aktive.gym.dto.request;

import com.aktive.gym.util.constants.CommonConstants;
import com.aktive.gym.validator.ValidEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

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
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$",
            message = "Password must be at least 8 characters long and must include an uppercase letter, lowercase letter, number, and special character"
    )
    private String password;

    @NotBlank(message = "Confirm password is mandatory")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$",
            message = "Password must be at least 8 characters long and must include an uppercase letter, lowercase letter, number, and special character"
    )
    private String confirmPassword;

    @ValidEnum(enumClass = CommonConstants.MembershipPlan.class)
    @NotBlank(message = "Membership plan is mandatory")
    private String membershipPlan;

    @Valid
    private FitnessAndBodyInfoRequest fitnessAndBodyInfo;

}
