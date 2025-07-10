package com.aktive.gym.dto.response;

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
public class UserResponse {

    private String name;
    private String email;
    private Date dateJoined;
    private CommonConstants.Gender gender;
    private Long age;
    private TrainerResponse trainer;
    private String status = "Active";
}
