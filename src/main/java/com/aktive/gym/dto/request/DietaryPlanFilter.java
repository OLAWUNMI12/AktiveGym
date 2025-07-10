package com.aktive.gym.dto.request;

import com.aktive.gym.util.constants.CommonConstants;
import com.aktive.gym.validator.ValidEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietaryPlanFilter {

    @ValidEnum(enumClass = CommonConstants.DietaryPlanType.class)
    private String type;

    @ValidEnum(enumClass = CommonConstants.FoodType.class)
    private String foodType;

    @Builder.Default
    private int pageNumber = 1;

    @Builder.Default
    private int pageSize = 10;




}


