package com.aktive.gym.dto.request;


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
public class CreateTrainerRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;
    @NotBlank(message = "Role is required")
    private String role;
    @NotNull(message = "Years of experience is required")
    private Integer yearsOfExperience;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Speciality is required")
    private String speciality;
    private String availablePeriod;
    private String certification;
    private double rating;
    private String email;
}
