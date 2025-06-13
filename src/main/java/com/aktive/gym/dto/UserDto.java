package com.aktive.gym.dto;


import com.aktive.gym.model.Trainer;
import com.aktive.gym.util.constants.CommonConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String fullName;

    private String membershipId;

    private CommonConstants.MembershipPlan membershipPlan;

    private String email;

    private CommonConstants.Gender gender;

    private Long age;

    private Double weight;

    private Double height;

    private String fitnessGoal;

    private CommonConstants.DietaryPreference dietaryPreference;

    private Trainer trainer;

    private Date createdAt;

    private Date updatedAt;

    private String token;

}
