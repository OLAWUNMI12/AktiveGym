package com.aktive.gym.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ExerciseResponse {


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FullBodyWorkoutDto {
        private boolean armCircles;
        private String armCirclesImageUrl = "https://i.pinimg.com/originals/62/30/be/6230beb8bf6fdb355efbaba3ccfbfa23.gif";
        private String armCirclesHowToDoIt = "Stand tall, extend your arms out, and rotate them in small forward circles. After 20 seconds, switch to backward circles. Keep arms straight and core engaged.";
        private boolean pikePushUp;
        private String pikePushUpImageUrl = "https://i.pinimg.com/originals/2b/b7/14/2bb714fc4307d33df93cf62d56f486b2.gif";
        private String pikePushUpHowToDoIt = "Start in a downward dog position. Lower your head toward the ground by bending your elbows, then push back up. Keep your hips high and core tight. Do 10 reps × 3 sets. Rest 30–45 seconds between sets.";
        private boolean tableTopReversePike;
        private String tableTopReversePikeImageUrl = "https://i.pinimg.com/originals/54/e5/13/54e5134acb78d3149582a203945acfc2.gif";
        private String tableTopReversePikeHowToDoIt = "Sit with feet flat and hands behind you. Lift your hips up until your body forms a flat tabletop. Squeeze your glutes, hold briefly, then lower.\n" +
                " Do 12 reps × 3 sets. Rest 30 seconds between sets.";
        private boolean plankBirdDog;
        private String plankBirdDogImageUrl = "https://i.pinimg.com/originals/91/e1/bc/91e1bc972552801178bb0dda55422f2c.gif";
        private String plankBirdDogHowToDoIt = "Start in a high plank. Extend your right arm and left leg at the same time, then return and switch sides. Keep your core tight and back flat. Do 10 reps per side × 3 sets. Rest 30 seconds between sets.\n";
        private boolean touchAndHop;
        private String touchAndHopImageUrl = "https://i.pinimg.com/originals/eb/46/39/eb46393a435cfd2659b1ad23891eaad4.gif";
        private String touchAndHopHowToDoIt = "Stand tall, then squat to touch the ground with one hand. As you rise, hop upward on both feet. Land softly and repeat.\n" +
                " Do 12 reps × 3 sets. Rest 30 seconds between sets.";

    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CoreAndFatBurnWorkoutDto {
        private boolean crunchChop;
        private String crunchChopImageUrl = "https://spotebi.com/wp-content/uploads/2016/03/crunch-chop-exercise-illustration-spotebi.gif\n";
        private String crunchChopHowToDoIt = "Lie on your back with arms and legs extended. Crunch up while bringing arms and legs together, like a chopping motion, then return to start.\n" +
                " Do 15 reps × 3 sets. Rest 30 seconds between sets.";
        private boolean mountainClimbers;
        private String mountainClimbersImageUrl = "https://spotebi.com/wp-content/uploads/2014/10/mountain-climbers-exercise-illustration-spotebi.gif";
        private String mountainClimbersHowToDoIt = "Start in a plank position with your hands directly under your shoulders and your body in a straight line from head to heels. Alternate bringing each knee towards your chest in a running motion. Keep your core tight and your hips low. Do 15 reps (per leg) × 3 sets. Rest 45 seconds between sets.\n";
        private boolean flutterKicks;
        private String flutterKicksImageUrl = "https://spotebi.com/wp-content/uploads/2014/10/flutter-kicks-exercise-illustration.gif";
        private String flutterKicksHowToDoIt = "Lie on your back with your hands tucked under your lower back or by your sides. Lift both legs a few inches off the ground. Keeping your legs straight, rapidly alternate raising one leg higher than the other in a small, controlled up-and-down motion. Do 20 reps (per leg) × 3 sets. Rest 45 seconds between sets.";
        private boolean frogCrunches;
        private String frogCrunchesImageUrl = "https://spotebi.com/wp-content/uploads/2016/02/frog-crunches-exercise-illustration-spotebi.gif";
        private String frogCrunchesHowToDoIt = "Lie on your back with your knees bent and your feet together, letting your knees fall open to the sides (like a frog). Place your hands lightly behind your head. Engage your core and crunch upward, bringing your shoulders off the ground and trying to touch your elbows to your knees. Slowly lower back down. Do 15 reps × 3 sets. Rest 30 seconds between sets.";
        private boolean pulseUp;
        private String pulseUpImageUrl = "https://spotebi.com/wp-content/uploads/2014/10/pulse-ups-exercise-illustration.gif";
        private String pulseUpHowToDoIt = "Lie on your back with your legs extended straight up towards the ceiling. Place your hands by your sides or under your lower back for support. Using your lower abs, lift your hips a few inches off the ground, pulsing them straight up towards the ceiling. Keep your legs as straight as possible. Do 15 reps × 3 sets. Rest 30 seconds between sets.";

    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpperBodyStretchWorkoutDto {
        private boolean staggeredArmPushUps;
        private String staggeredArmPushUpsImageUrl = "https://i.pinimg.com/originals/4f/ba/7a/4fba7a35d597905f7241c69712cc6965.gif\n";
        private String staggeredArmPushUpsHowToDoIt = "Start in a push-up with one hand forward, one back. Lower, then push up. Switch hand positions between sets. Do 10 reps (per side) × 3 sets. Rest 60 seconds.\n";
        private boolean supermanTwist;
        private String supermanTwistImageUrl = "https://i.pinimg.com/originals/e7/67/01/e767015e4c2c6e9e3dfb7fa68621da0d.gif\n";
        private String supermanTwistHowToDoIt = "Lie face down, lift arms/chest/legs. Twist torso side-to-side while lifted. Do 12 reps (alternating) × 3 sets. Rest 45 seconds.\n";
        private boolean spidermanPushUps;
        private String spidermanPushUpsImageUrl = "https://i.pinimg.com/originals/4b/20/d6/4b20d60a2f6b5ee0e414b20266b62f91.gif\n";
        private String spidermanPushUpsHowToDoIt = "Do a push-up. As you lower, bring one knee to its elbow. Alternate sides. Do 10 reps (per side) × 3 sets. Rest 60 seconds.";
        private boolean standingMountainClimbers;
        private String standingMountainClimbersImageUrl = "https://i.pinimg.com/originals/84/d4/bb/84d4bbc8434765b2e374a919cbd31052.gif\n";
        private String standingMountainClimbersHowToDoIt = "Stand, rapidly alternate bringing knees to chest. Keep the core tight. Do 20 reps (per leg) × 3 sets. Rest 30 seconds.";
        private boolean boatTwist;
        private String boatTwistImageUrl = "https://i.pinimg.com/originals/03/b1/9c/03b19c7b504c50ee3696a1e6f33b1880.gif\n";
        private String boatTwistHowToDoIt = "Sit, lift feet, lean back. Twist torso side-to-side. Do 15 reps (per side) × 3 sets. Rest 45 seconds.";

    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class fullLegWorkoutDto {
        private boolean ankleHops;
        private String ankleHopsImageUrl = "https://spotebi.com/wp-content/uploads/2015/02/ankle-hops-exercise-illustration.gif\n";
        private String ankleHopsHowToDoIt = "Stand tall, slight knee bend. Hop quickly on the balls of your feet, just an inch or two off the ground, focusing on ankle elasticity. Do 30 seconds × 3 sets. Rest 30 seconds.";
        private boolean calfRaise;
        private String calfRaiseImageUrl = "https://spotebi.com/wp-content/uploads/2015/05/calf-raises-exercise-illustration.gif\n";
        private String calfRaiseHowToDoIt = "Stand with feet flat (or heels hanging off a step). Raise up onto the balls of your feet, squeezing your calves. Lower slowly. Do 15 reps × 3 sets. Rest 30 seconds.";
        private boolean theTouchAndHop;
        private String theTouchAndHopImageUrl = "https://spotebi.com/wp-content/uploads/2016/02/touch-and-hop-exercise-illustration-spotebi.gif";
        private String theTouchAndHopHowToDoIt = "Stand tall. Squat to touch the ground with one hand. As you rise, hop upward on both feet. Land softly and repeat. Do 12 reps × 3 sets. Rest 30 seconds.";
        private boolean basketballShots;
        private String basketballShotsImageUrl = "https://spotebi.com/wp-content/uploads/2016/02/basketball-shots-exercise-illustration-spotebi.gif";
        private String basketballShotsHowToDoIt = "Simulate shooting a basketball. Focus on form, release, and follow-through. Jump if desired. Do 20 shots × 3 sets. Rest 45 seconds.";
        private boolean jumpRope;
        private String jumpRopeImageUrl = "https://spotebi.com/wp-content/uploads/2014/10/jump-rope-exercise-illustration.gif\n";
        private String jumpRopeHowToDoIt = "Continuous jumping over a jump rope. Maintain a consistent rhythm. Do 60 seconds × 3 sets. Rest 45 seconds.\n";
    }
}
