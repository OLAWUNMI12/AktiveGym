package com.aktive.gym.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "user_exercises")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    private String username;
    private boolean armCircles;
    private boolean pikePushUp;
    private boolean tableTopReversePike;
    private boolean plankBirdDog;
    private boolean touchAndHop;
    private boolean crunchChop;
    private boolean mountainClimbers;
    private boolean flutterKicks;
    private boolean frogCrunches;
    private boolean pulseUp;
    private boolean staggeredArmPushUps;
    private boolean supermanTwist;
    private boolean spidermanPushUps;
    private boolean standingMountainClimbers;
    private boolean boatTwist;
    private boolean ankleHops;
    private boolean calfRaise;
    private boolean theTouchAndHop;
    private boolean basketballShots;
    private boolean jumpRope;
    private Integer workoutProgress;


}
