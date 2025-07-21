package com.aktive.gym.controller;

import com.aktive.gym.dto.request.Notificationfilter;
import com.aktive.gym.model.Notification;
import com.aktive.gym.service.NotificationService;
import com.aktive.gym.service.pagination.CustomPage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {


    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<CustomPage<Notification>> getNotifications(@Valid Notificationfilter notificationfilter){
        return ResponseEntity.ok().body(notificationService.getNotifications(notificationfilter));
    }


    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long notificationId){
        return ResponseEntity.ok().body(notificationService.getNotification(notificationId));
    }

}
