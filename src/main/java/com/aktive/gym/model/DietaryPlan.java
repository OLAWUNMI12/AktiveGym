package com.aktive.gym.model;


import com.aktive.gym.util.constants.CommonConstants;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "dietary_plan")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietaryPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type")
    private CommonConstants.DietaryPlanType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "food_type")
    private CommonConstants.FoodType foodType;

    private int calories;
    private int carbs;
    private int protein;
    private int fat;


    @Column(nullable = true)
    private String direction;
    @Column(nullable = true)
    private String ingredient;
    @Column(nullable = true)
    private String tools;
    @Column(nullable = true)
    private String note;
    @Column(nullable = true)
    private int prepTime;
    @Column(nullable = true)
    private int cookTime;
    @Column(nullable = true)
    private String healthScore;

}
