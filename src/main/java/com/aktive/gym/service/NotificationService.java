package com.aktive.gym.service;


import com.aktive.gym.dto.request.Notificationfilter;
import com.aktive.gym.model.Notification;
import com.aktive.gym.repo.NotificationRepository;
import com.aktive.gym.service.pagination.CustomPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public CustomPage<Notification> getNotifications(Notificationfilter notificationfilter){
        Pageable pageable = PageRequest.of(notificationfilter.getPageNumber() - 1, notificationfilter.getPageSize());
        Page<Notification> notificationsPage =
                notificationRepository.findAll(pageable);
        return getNotificationResponseCustomPage(notificationsPage.getContent(), notificationsPage, notificationfilter);
    }

    private static CustomPage<Notification> getNotificationResponseCustomPage(List<Notification> notifications, Page notificationsPage, Notificationfilter notificationfilter) {
        CustomPage<Notification> customPage = new CustomPage<>();
        customPage.setContent(notifications);
        customPage.setPageNumber(notificationsPage.getNumber() + 1);
        customPage.setPageSize(notificationsPage.getSize());
        customPage.setTotalElements(notificationsPage.getTotalElements());
        customPage.setTotalPages(notificationsPage.getTotalPages());
        customPage.setLast(notificationsPage.isLast());
        customPage.setFirst(notificationsPage.isFirst());
        customPage.setEmpty(notificationsPage.isEmpty());
        return customPage;
    }



    public Notification getNotification(Long notificationId){
        return notificationRepository.findById(notificationId).orElseThrow(() -> new IllegalArgumentException("Notification not found"));
    }
}
