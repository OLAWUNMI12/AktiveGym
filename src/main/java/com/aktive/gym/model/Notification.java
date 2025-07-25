package com.aktive.gym.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Table(name = "notification")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;


    private String subject;
    private String message;
    private String notificationType;
    private Date createdAt;

}
