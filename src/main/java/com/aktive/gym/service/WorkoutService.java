package com.aktive.gym.service;


import com.aktive.gym.dto.response.ComputeWorkoutProgressResponse;
import com.aktive.gym.dto.response.ExerciseResponse;
import com.aktive.gym.model.User;
import com.aktive.gym.model.UserExercises;
import com.aktive.gym.repo.UserExerciseRepository;
import com.aktive.gym.util.constants.CommonConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkoutService {


    private final UserExerciseRepository userExerciseRepository;
    private final UserService userService;

    public ComputeWorkoutProgressResponse computeFullBodyWorkout(CommonConstants.Excercises excercise, Boolean value){
        User user = userService.getCurrentUser();
        Optional<UserExercises> userExercisesOptional = userExerciseRepository.findByUsername(user.getUsername());
        UserExercises userExercises = userExercisesOptional.orElse(UserExercises.builder().username(user.getUsername()).build());
        int fullBodyWorkout = Objects.nonNull(userExercises.getWorkoutProgress()) ? userExercises.getWorkoutProgress() : 0;

        fullBodyWorkout = computeBodyWorkout(userExercises, excercise, fullBodyWorkout, value);
        fullBodyWorkout = computeUpperBodyStretchWorkout(userExercises, excercise, fullBodyWorkout, value);
        fullBodyWorkout = computeFullLegWorkout(userExercises, excercise, fullBodyWorkout, value);
        fullBodyWorkout = computeCoreAndFatBurnWorkout(userExercises, excercise, fullBodyWorkout, value);

        userExercises.setWorkoutProgress(fullBodyWorkout);
        userExerciseRepository.save(userExercises);
        return ComputeWorkoutProgressResponse.builder()
                .workoutProgress(fullBodyWorkout)
                .exercise(excercise)
                .flag(value)
                .build();
    }

    private int computeBodyWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, Integer fullBodyWorkout, boolean value){

        switch (excercise) {
            case ARM_CIRCLES:
                if (userExercises.isArmCircles() != value) {
                    userExercises.setArmCircles(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case PIKE_PUSH_UP:
                if (userExercises.isPikePushUp() != value) {
                    userExercises.setPikePushUp(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case TABLE_TOP_REVERSE_PIKE:
                if (userExercises.isTableTopReversePike() != value) {
                    userExercises.setTableTopReversePike(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case PLANK_BIRD_DOG:
                if (userExercises.isPlankBirdDog() != value) {
                    userExercises.setPlankBirdDog(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case TOUCH_AND_HOP:
                if (userExercises.isTouchAndHop() != value) {
                    userExercises.setTouchAndHop(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            default:
                break;
        }

        return fullBodyWorkout;
    }

    private int computeCoreAndFatBurnWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, Integer fullBodyWorkout, boolean value){

        switch (excercise) {
            case CRUNCH_CHOP:
                if (userExercises.isCrunchChop() != value) {
                    userExercises.setCrunchChop(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case MOUNTAIN_CLIMBERS:
                if (userExercises.isMountainClimbers() != value) {
                    userExercises.setMountainClimbers(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case FLUTTER_KICKS:
                if (userExercises.isFlutterKicks() != value) {
                    userExercises.setFlutterKicks(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case FROG_CRUNCHES:
                if (userExercises.isFrogCrunches() != value) {
                    userExercises.setFrogCrunches(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case PULSE_UP:
                if (userExercises.isPulseUp() != value) {
                    userExercises.setPulseUp(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            default:
                break;
        }
        return fullBodyWorkout;
    }

    private int computeUpperBodyStretchWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, Integer fullBodyWorkout, boolean value){
        switch (excercise) {
            case STAGGERED_ARM_PUSH_UPS:
                if (userExercises.isStaggeredArmPushUps() != value) {
                    userExercises.setStaggeredArmPushUps(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;


            case SUPERMAN_TWIST:
                if (userExercises.isSupermanTwist() != value) {
                    userExercises.setSupermanTwist(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;


            case SPIDERMAN_PUSH_UPS:
                if (userExercises.isSpidermanPushUps() != value) {
                    userExercises.setSpidermanPushUps(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;


            case STANDING_MOUNTAIN_CLIMBERS:
                if (userExercises.isStandingMountainClimbers() != value) {
                    userExercises.setStandingMountainClimbers(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;


            case BOAT_TWIST:
                if (userExercises.isBoatTwist() != value) {
                    userExercises.setBoatTwist(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            default:
                break;

        }
        return fullBodyWorkout;
    }

    private int computeFullLegWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, Integer fullBodyWorkout, boolean value){
        switch (excercise) {
            case ANKLE_HOPS:
                if (userExercises.isAnkleHops() != value) {
                    userExercises.setAnkleHops(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case CALF_RAISES:
                if (userExercises.isCalfRaise() != value) {
                    userExercises.setCalfRaise(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case THE_TOUCH_AND_HOP:
                if (userExercises.isTheTouchAndHop() != value) {
                    userExercises.setTheTouchAndHop(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case BASKETBALL_SHOTS:
                if (userExercises.isBasketballShots() != value) {
                    userExercises.setBasketballShots(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;

            case JUMP_ROPE:
                if (userExercises.isJumpRope() != value) {
                    userExercises.setJumpRope(value);
                    fullBodyWorkout = computeFullBodyWorkout(excercise, fullBodyWorkout, value);
                }
                break;
            default:
                break;
        }
        return fullBodyWorkout;
    }


    public Integer computeFullBodyWorkout(CommonConstants.Excercises excercise, Integer fullBodyWorkout, Boolean flag){
        if(fullBodyWorkout >= 0){
            if(Boolean.TRUE.equals(flag)){
                fullBodyWorkout += excercise.getValue();
            }else {
                fullBodyWorkout -= excercise.getValue();
            }
        }
        return fullBodyWorkout;
    }



    public Object getWorkoutPlan(String type){
        User user = userService.getCurrentUser();
        Optional<UserExercises> userExercisesOptional = userExerciseRepository.findByUsername(user.getUsername());
        UserExercises userExercises = userExercisesOptional.orElse(UserExercises.builder().username(user.getUsername()).build());

        CommonConstants.WorkoutPlan workoutPlan = CommonConstants.WorkoutPlan.valueOf(type);

        return switch (workoutPlan) {
            case FULL_BODY_WORKOUT -> getFullBodyWorkout(userExercises);
            case CORE_AND_FAT_BURN_WORKOUT -> getCoreAndFatBurnWorkout(userExercises);
            case UPPER_BODY_STRETCH_WORKOUT -> getUpperBodyStretchWorkout(userExercises);
            case FULL_LEG_WORKOUT -> getFullLegWorkout(userExercises);
            default -> null;
        };
    }


    private ExerciseResponse.FullBodyWorkoutDto getFullBodyWorkout(UserExercises userExercises){
        ExerciseResponse.FullBodyWorkoutDto fullBodyWorkout = new ExerciseResponse.FullBodyWorkoutDto();
        fullBodyWorkout.setArmCircles(userExercises.isArmCircles());
        fullBodyWorkout.setPikePushUp(userExercises.isPikePushUp());
        fullBodyWorkout.setTableTopReversePike(userExercises.isTableTopReversePike());
        fullBodyWorkout.setPlankBirdDog(userExercises.isPlankBirdDog());
        fullBodyWorkout.setTouchAndHop(userExercises.isTouchAndHop());
        return fullBodyWorkout;
    }

    private ExerciseResponse.CoreAndFatBurnWorkoutDto getCoreAndFatBurnWorkout(UserExercises userExercises){
        ExerciseResponse.CoreAndFatBurnWorkoutDto coreAndFatBurnWorkout = new ExerciseResponse.CoreAndFatBurnWorkoutDto();
        coreAndFatBurnWorkout.setCrunchChop(userExercises.isCrunchChop());
        coreAndFatBurnWorkout.setMountainClimbers(userExercises.isMountainClimbers());
        coreAndFatBurnWorkout.setFlutterKicks(userExercises.isFlutterKicks());
        coreAndFatBurnWorkout.setFrogCrunches(userExercises.isFrogCrunches());
        coreAndFatBurnWorkout.setPulseUp(userExercises.isPulseUp());
        return coreAndFatBurnWorkout;
    }

    private ExerciseResponse.UpperBodyStretchWorkoutDto getUpperBodyStretchWorkout(UserExercises userExercises){
        ExerciseResponse.UpperBodyStretchWorkoutDto upperBodyStretchWorkout = new ExerciseResponse.UpperBodyStretchWorkoutDto();
        upperBodyStretchWorkout.setStaggeredArmPushUps(userExercises.isStaggeredArmPushUps());
        upperBodyStretchWorkout.setSupermanTwist(userExercises.isSupermanTwist());
        upperBodyStretchWorkout.setSpidermanPushUps(userExercises.isSpidermanPushUps());
        upperBodyStretchWorkout.setStandingMountainClimbers(userExercises.isStandingMountainClimbers());
        upperBodyStretchWorkout.setBoatTwist(userExercises.isBoatTwist());
        return upperBodyStretchWorkout;
    }

    private ExerciseResponse.fullLegWorkoutDto getFullLegWorkout(UserExercises userExercises){
        ExerciseResponse.fullLegWorkoutDto fullLegWorkout = new ExerciseResponse.fullLegWorkoutDto();
        fullLegWorkout.setAnkleHops(userExercises.isAnkleHops());
        fullLegWorkout.setCalfRaise(userExercises.isCalfRaise());
        fullLegWorkout.setTheTouchAndHop(userExercises.isTheTouchAndHop());
        fullLegWorkout.setBasketballShots(userExercises.isBasketballShots());
        fullLegWorkout.setJumpRope(userExercises.isJumpRope());
        return fullLegWorkout;
    }

}
