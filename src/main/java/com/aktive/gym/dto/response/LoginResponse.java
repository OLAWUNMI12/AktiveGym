package com.aktive.gym.dto.response;


import com.aktive.gym.util.constants.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String token;

    private long expiresIn;

    private String username;

    private CommonConstants.UserRole userRole;
}
