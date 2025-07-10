package com.aktive.gym.service;

import com.aktive.gym.dto.request.DietaryPlanFilter;
import com.aktive.gym.model.DietaryPlan;
import com.aktive.gym.repo.DietaryPlanRepository;
import com.aktive.gym.service.pagination.CustomPage;
import com.aktive.gym.util.constants.CommonConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DietaryPlanService {

    private final DietaryPlanRepository dietaryPlanRepository;

    public CustomPage<DietaryPlan> getDietaryPlans(DietaryPlanFilter dietaryPlanFilter){
        Pageable pageable = PageRequest.of(dietaryPlanFilter.getPageNumber() - 1, dietaryPlanFilter.getPageSize());
        Page<DietaryPlan> dietaryPlanPage =
                dietaryPlanRepository.searchDietaryPlans(
                        StringUtils.hasText(dietaryPlanFilter.getType()) ? CommonConstants.DietaryPlanType.valueOf(dietaryPlanFilter.getType()) : null,
                        StringUtils.hasText(dietaryPlanFilter.getFoodType()) ? CommonConstants.FoodType.valueOf(dietaryPlanFilter.getFoodType()) : null,
                        pageable);
        return getDietaryPlanResponseCustomPage(dietaryPlanPage.getContent(), dietaryPlanPage, dietaryPlanFilter);
    }

    private static CustomPage<DietaryPlan> getDietaryPlanResponseCustomPage(List<DietaryPlan> dietaryPlans, Page dietaryPlanPage, DietaryPlanFilter request) {
        CustomPage<DietaryPlan> customPage = new CustomPage<>();
        customPage.setContent(dietaryPlans);
        customPage.setPageNumber(dietaryPlanPage.getNumber() + 1);
        customPage.setPageSize(dietaryPlanPage.getSize());
        customPage.setTotalElements(dietaryPlanPage.getTotalElements());
        customPage.setTotalPages(dietaryPlanPage.getTotalPages());
        customPage.setLast(dietaryPlanPage.isLast());
        customPage.setFirst(dietaryPlanPage.isFirst());
        customPage.setEmpty(dietaryPlanPage.isEmpty());
        return customPage;
    }



    public DietaryPlan getDietaryPlan(Long dietaryPlanId){
        return dietaryPlanRepository.findById(dietaryPlanId).orElseThrow(() -> new IllegalArgumentException("Dietary plan not found"));
    }
}

