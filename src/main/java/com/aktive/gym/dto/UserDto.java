package com.aktive.gym.dto;


import com.aktive.gym.util.constants.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String fullName;

    private String membershipId;

    private CommonConstants.MembershipPlan membershipPlan;

    private String email;

    private Date createdAt;

    private Date updatedAt;

    private String token;

}
