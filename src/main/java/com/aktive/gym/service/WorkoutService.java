package com.aktive.gym.service;


import com.aktive.gym.dto.response.ComputeWorkoutProgressResponse;
import com.aktive.gym.dto.response.ExerciseResponse;
import com.aktive.gym.model.FitnessAndBodyInfo;
import com.aktive.gym.model.User;
import com.aktive.gym.model.UserExercises;
import com.aktive.gym.repo.UserExerciseRepository;
import com.aktive.gym.repo.UserRepository;
import com.aktive.gym.util.constants.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkoutService {


    private final UserExerciseRepository userExerciseRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public ComputeWorkoutProgressResponse computeFullBodyWorkout(CommonConstants.Excercises excercise, Boolean value){
        User registeredUser = userService.getCurrentUser();
        User user = userRepository.findByEmail(registeredUser.getEmail()).orElse(null);
        FitnessAndBodyInfo fitnessAndBodyInfo = user.getFitnessAndBodyInfo();

        Optional<UserExercises> userExercisesOptional = userExerciseRepository.findByUsername(user.getUsername());
        UserExercises userExercises = userExercisesOptional.orElse(UserExercises.builder().username(user.getUsername()).build());
        int fullBodyWorkout = Objects.nonNull(userExercises.getWorkoutProgress()) ? userExercises.getWorkoutProgress() : 0;
        double fullBodyWorkoutMet = Objects.nonNull(userExercises.getWorkoutMet()) ? userExercises.getWorkoutMet() : 0;
        ExerciseMetricsResponse exerciseMetricsResponse = new ExerciseMetricsResponse(fullBodyWorkout, fullBodyWorkoutMet);


        exerciseMetricsResponse = computeBodyWorkout(userExercises, excercise, exerciseMetricsResponse, value);
        exerciseMetricsResponse = computeUpperBodyStretchWorkout(userExercises, excercise, exerciseMetricsResponse, value);
        exerciseMetricsResponse = computeFullLegWorkout(userExercises, excercise, exerciseMetricsResponse, value);
        exerciseMetricsResponse = computeCoreAndFatBurnWorkout(userExercises, excercise, exerciseMetricsResponse, value);

        userExercises.setWorkoutMet(exerciseMetricsResponse.getWorkoutMet());
        double caloriesBurned = exerciseMetricsResponse.getWorkoutMet() * fitnessAndBodyInfo.getWeight() * 0.0833;
        caloriesBurned = (double) Math.round(caloriesBurned * 100) / 100;
        userExercises.setCaloriesBurned(caloriesBurned);
        userExercises.setWorkoutProgress(exerciseMetricsResponse.getWorkoutProgress());
        userExerciseRepository.save(userExercises);
        return ComputeWorkoutProgressResponse.builder()
                .workoutProgress(exerciseMetricsResponse.getWorkoutProgress())
                .caloriesBurned(caloriesBurned)
                .exercise(excercise)
                .flag(value)
                .build();
    }

    private ExerciseMetricsResponse computeBodyWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, ExerciseMetricsResponse exerciseMetricsResponse, boolean value){

        switch (excercise) {
            case ARM_CIRCLES:
                if (userExercises.isArmCircles() != value) {
                    userExercises.setArmCircles(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case PIKE_PUSH_UP:
                if (userExercises.isPikePushUp() != value) {
                    userExercises.setPikePushUp(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case TABLE_TOP_REVERSE_PIKE:
                if (userExercises.isTableTopReversePike() != value) {
                    userExercises.setTableTopReversePike(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case PLANK_BIRD_DOG:
                if (userExercises.isPlankBirdDog() != value) {
                    userExercises.setPlankBirdDog(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case TOUCH_AND_HOP:
                if (userExercises.isTouchAndHop() != value) {
                    userExercises.setTouchAndHop(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            default:
                break;
        }

        return exerciseMetricsResponse;
    }

    private ExerciseMetricsResponse computeCoreAndFatBurnWorkout(UserExercises userExercises, CommonConstants.Excercises excercise,  ExerciseMetricsResponse exerciseMetricsResponse, boolean value){

        switch (excercise) {
            case CRUNCH_CHOP:
                if (userExercises.isCrunchChop() != value) {
                    userExercises.setCrunchChop(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case MOUNTAIN_CLIMBERS:
                if (userExercises.isMountainClimbers() != value) {
                    userExercises.setMountainClimbers(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case FLUTTER_KICKS:
                if (userExercises.isFlutterKicks() != value) {
                    userExercises.setFlutterKicks(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case FROG_CRUNCHES:
                if (userExercises.isFrogCrunches() != value) {
                    userExercises.setFrogCrunches(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case PULSE_UP:
                if (userExercises.isPulseUp() != value) {
                    userExercises.setPulseUp(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            default:
                break;
        }
        return exerciseMetricsResponse;
    }

    private ExerciseMetricsResponse computeUpperBodyStretchWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, ExerciseMetricsResponse exerciseMetricsResponse, boolean value){
        switch (excercise) {
            case STAGGERED_ARM_PUSH_UPS:
                if (userExercises.isStaggeredArmPushUps() != value) {
                    userExercises.setStaggeredArmPushUps(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;


            case SUPERMAN_TWIST:
                if (userExercises.isSupermanTwist() != value) {
                    userExercises.setSupermanTwist(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;


            case SPIDERMAN_PUSH_UPS:
                if (userExercises.isSpidermanPushUps() != value) {
                    userExercises.setSpidermanPushUps(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;


            case STANDING_MOUNTAIN_CLIMBERS:
                if (userExercises.isStandingMountainClimbers() != value) {
                    userExercises.setStandingMountainClimbers(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;


            case BOAT_TWIST:
                if (userExercises.isBoatTwist() != value) {
                    userExercises.setBoatTwist(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            default:
                break;

        }
        return exerciseMetricsResponse;
    }

    private ExerciseMetricsResponse computeFullLegWorkout(UserExercises userExercises, CommonConstants.Excercises excercise, ExerciseMetricsResponse exerciseMetricsResponse, boolean value){
        switch (excercise) {
            case ANKLE_HOPS:
                if (userExercises.isAnkleHops() != value) {
                    userExercises.setAnkleHops(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case CALF_RAISES:
                if (userExercises.isCalfRaise() != value) {
                    userExercises.setCalfRaise(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case THE_TOUCH_AND_HOP:
                if (userExercises.isTheTouchAndHop() != value) {
                    userExercises.setTheTouchAndHop(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case BASKETBALL_SHOTS:
                if (userExercises.isBasketballShots() != value) {
                    userExercises.setBasketballShots(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;

            case JUMP_ROPE:
                if (userExercises.isJumpRope() != value) {
                    userExercises.setJumpRope(value);
                    exerciseMetricsResponse = computeFullBodyWorkout(excercise, exerciseMetricsResponse, value);
                }
                break;
            default:
                break;
        }
        return exerciseMetricsResponse;
    }


    public ExerciseMetricsResponse computeFullBodyWorkout(CommonConstants.Excercises excercise, ExerciseMetricsResponse exerciseMetricsResponse, Boolean flag){
        Integer fullBodyWorkout = exerciseMetricsResponse.getWorkoutProgress();
        Double fullBodyWorkoutMet = exerciseMetricsResponse.getWorkoutMet();
        if(fullBodyWorkout >= 0){
            if(Boolean.TRUE.equals(flag)){
                fullBodyWorkout += excercise.getValue();
                fullBodyWorkoutMet += excercise.getMET();
            }else {
                fullBodyWorkout -= excercise.getValue();
                fullBodyWorkoutMet -= excercise.getMET();
            }
        }
        return new ExerciseMetricsResponse(fullBodyWorkout, fullBodyWorkoutMet);
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

    @Data
    @AllArgsConstructor
    public class ExerciseMetricsResponse {
        private Integer workoutProgress;
        private Double workoutMet;
    }

}

