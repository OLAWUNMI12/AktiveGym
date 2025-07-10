package com.aktive.gym.repo;

import com.aktive.gym.model.DietaryPlan;
import com.aktive.gym.util.constants.CommonConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DietaryPlanRepository extends JpaRepository<DietaryPlan, Long> {


    @Query("SELECT d FROM DietaryPlan d WHERE" +
            " (:type IS NULL OR  d.type = :type)  AND " +
            " (:foodType IS NULL OR  d.foodType = :foodType) "
    )
    Page<DietaryPlan> searchDietaryPlans(CommonConstants.DietaryPlanType type, CommonConstants.FoodType foodType, Pageable pageable);
}
