package com.aktive.gym.validator;

import com.aktive.gym.util.constants.CommonConstants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FitnessGoalValidator implements ConstraintValidator<ValidFitnessGoal, List<String>> {

    private final Set<String> allowedHobbies = Stream.of(CommonConstants.FitnessGoal.values())
            .map(Enum::name)
            .collect(Collectors.toSet());

    @Override
    public boolean isValid(List<String> values, ConstraintValidatorContext context) {
        if (values == null || values.isEmpty()) {
            return false;
        }
        for (String value : values) {
            if (!allowedHobbies.contains(value.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

}