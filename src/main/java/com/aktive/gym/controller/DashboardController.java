package com.aktive.gym.controller;


import com.aktive.gym.dto.response.UserDashboardResponse;
import com.aktive.gym.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/user/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashBoardService dashBoardService;


    @GetMapping()
    public ResponseEntity<UserDashboardResponse> getUserDashboard(){
        return ResponseEntity.ok().body(dashBoardService.getUserDashboard());
    }
}
