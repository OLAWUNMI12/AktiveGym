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
public class GetTrainerRequest {

    private String searchQuery;

    @ValidEnum(enumClass = CommonConstants.Category.class)
    private String category;

    @Builder.Default
    private int pageNumber = 1;

    @Builder.Default
    private int pageSize = 10;
}
