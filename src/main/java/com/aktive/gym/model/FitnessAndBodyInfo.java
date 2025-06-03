package com.aktive.gym.model;

import com.aktive.gym.util.constants.CommonConstants;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "fitness_and_body_info")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FitnessAndBodyInfo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    private Double weight;

    private Double height;

    private Double bmi;

    @Column(nullable = false, name = "fitness_goal")
    private String fitnessGoal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "dietary_preference")
    private CommonConstants.DietaryPreference dietaryPreference;
}
