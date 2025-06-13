package com.aktive.gym.util.constants;

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

    public enum Excercises {
        // FULL BODY WORKOUT
        ARM_CIRCLES(5),
        PIKE_PUSH_UP(5),
        TABLE_TOP_REVERSE_PIKE(5),
        PLANK_BIRD_DOG(5),
        TOUCH_AND_HOP(5),


        //CORE AND FAT BURN
        CRUNCH_CHOP(5),
        MOUNTAIN_CLIMBERS(5),
        FLUTTER_KICKS(5),
        FROG_CRUNCHES(5),
        PULSE_UP(5),

        // UPPER BODY STRETCH
        STAGGERED_ARM_PUSH_UPS(5),
        SUPERMAN_TWIST(5),
        SPIDERMAN_PUSH_UPS(5),
        STANDING_MOUNTAIN_CLIMBERS(5),
        BOAT_TWIST(5),

        //FULL LEG WORKOUT
        ANKLE_HOPS(5),
        CALF_RAISES(5),
        THE_TOUCH_AND_HOP(5),
        BASKETBALL_SHOTS(5),
        JUMP_ROPE(5);


        private final int value;

        Excercises(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public enum WorkoutPlan {
        FULL_BODY_WORKOUT,
        CORE_AND_FAT_BURN_WORKOUT,
        UPPER_BODY_STRETCH_WORKOUT,
        FULL_LEG_WORKOUT
    }
}
