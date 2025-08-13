package com.aktive.gym.model;


import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Table(name = "trainer")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    private String fullName;
    private String role;
    private int yearsOfExperience;
    private String description;
    private String speciality;
    private String availablePeriod;
    private String certification;
    private double rating;
    private String status = "Active";
    private String email;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;


    @PrePersist
    public void prePersist() {
        if (StringUtils.isBlank(status)) {
            status = "Active";
        }
    }

}
