package com.aktive.gym.util.constants;

import lombok.Getter;

public class CommonConstants {

    public enum Gender {
        MALE,
        FEMALE;
    }

    public enum MembershipPlan {
        STUDENT,
        REGULAR,
        PREMIUM;
    }

    public enum FitnessGoal {
        LOOSE_WEIGHT,
        BUILD_MUSCLE,
        GET_FLEXIBLE,
    }

    public enum DietaryPreference {
        VEGAN,
        HIGH_PROTEIN,
        NO_PREFERENCE
    }

    public enum Category {
        ALL,
        NEW,
        PAST
    }

    public enum Excercises {
        // FULL BODY WORKOUT
        ARM_CIRCLES(5, 3),
        PIKE_PUSH_UP(5,6),
        TABLE_TOP_REVERSE_PIKE(5, 5),
        PLANK_BIRD_DOG(5, 4),
        TOUCH_AND_HOP(5, 7),


        //CORE AND FAT BURN
        CRUNCH_CHOP(5, 4),
        MOUNTAIN_CLIMBERS(5, 8),
        FLUTTER_KICKS(5, 4.5),
        FROG_CRUNCHES(5, 4),
        PULSE_UP(5, 4.5),

        // UPPER BODY STRETCH
        STAGGERED_ARM_PUSH_UPS(5, 6),
        SUPERMAN_TWIST(5, 4.5),
        SPIDERMAN_PUSH_UPS(5, 7),
        STANDING_MOUNTAIN_CLIMBERS(5, 6.5),
        BOAT_TWIST(5, 4.5),

        //FULL LEG WORKOUT
        ANKLE_HOPS(5, 8),
        CALF_RAISES(5, 3.5),
        THE_TOUCH_AND_HOP(5, 7),
        BASKETBALL_SHOTS(5, 6),
        JUMP_ROPE(5, 12);


        @Getter
        private final int value;

        @Getter
        private final double MET;

        Excercises(int value, double met) {
            this.value = value;
            MET = met;
        }

    }


    public enum WorkoutPlan {
        FULL_BODY_WORKOUT,
        CORE_AND_FAT_BURN_WORKOUT,
        UPPER_BODY_STRETCH_WORKOUT,
        FULL_LEG_WORKOUT
    }

    public enum DietaryPlanType {
        LOOSE_WEIGHT,
        MAINTAIN_WEIGHT,
        GAIN_WEIGHT
    }

    public enum FoodType
    {
        VEGAN,
        NON_VEGAN
    }
}
