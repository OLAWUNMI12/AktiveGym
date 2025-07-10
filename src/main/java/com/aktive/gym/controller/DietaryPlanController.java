package com.aktive.gym.controller;

import com.aktive.gym.dto.request.DietaryPlanFilter;
import com.aktive.gym.model.DietaryPlan;
import com.aktive.gym.service.DietaryPlanService;
import com.aktive.gym.service.pagination.CustomPage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/dietary-plan")
@RequiredArgsConstructor
public class DietaryPlanController {


    private final DietaryPlanService dietaryPlanService;

    @GetMapping
    public ResponseEntity<CustomPage<DietaryPlan>> getDietaryPlans(@Valid DietaryPlanFilter dietaryPlanFilter){
        return ResponseEntity.ok().body(dietaryPlanService.getDietaryPlans(dietaryPlanFilter));
    }


    @GetMapping("/{dietaryPlanId}")
    public ResponseEntity<DietaryPlan> getDietaryPlan(@PathVariable Long dietaryPlanId){
        return ResponseEntity.ok().body(dietaryPlanService.getDietaryPlan(dietaryPlanId));
    }


}
