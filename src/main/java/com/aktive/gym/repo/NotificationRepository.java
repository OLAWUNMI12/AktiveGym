package com.aktive.gym.repo;

import com.aktive.gym.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository  extends JpaRepository<Notification, Long> {
}
