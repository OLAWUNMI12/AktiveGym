package com.aktive.gym.controller;


import com.aktive.gym.config.JwtService;
import com.aktive.gym.dto.request.LoginRequest;
import com.aktive.gym.dto.response.LoginResponse;
import com.aktive.gym.dto.request.RegisterUserRequest;
import com.aktive.gym.dto.UserDto;
import com.aktive.gym.model.User;
import com.aktive.gym.service.AuthenticationService;
import com.aktive.gym.service.TokenBlacklistService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/auth")
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    private final TokenBlacklistService tokenBlacklistService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, TokenBlacklistService tokenBlacklistService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterUserRequest registerUserRequest) throws BadRequestException {
        UserDto registeredUser = authenticationService.signup(registerUserRequest);
        User user = new User();
        user.setEmail(registeredUser.getEmail());
        registeredUser.setToken(jwtService.generateToken(user));
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody LoginRequest loginUserDto) {
            User authenticatedUser = authenticationService.authenticate(loginUserDto);

            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse loginResponse =  LoginResponse.builder()
                    .token(jwtToken)
                    .expiresIn(jwtService.getExpirationTime())
                    .username(loginUserDto.getEmail())
                    .userRole(authenticatedUser.getUserRole())
                    .build();

            return ResponseEntity.ok(loginResponse);
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            tokenBlacklistService.blacklistToken(token);
            return ResponseEntity.ok().body("{\"message\": \"Logged out successfully\"}");
        }

        return ResponseEntity.badRequest().body("{\"error\": \"Invalid request\", \"message\": \"No token provided\"}");
    }




}
