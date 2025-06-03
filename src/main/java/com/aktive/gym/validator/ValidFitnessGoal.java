package com.aktive.gym.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FitnessGoalValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFitnessGoal {
    String message() default "Invalid Fitness Goal found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
