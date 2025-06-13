package com.aktive.gym.dto.request;


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

    @Builder.Default
    private int pageNumber = 1;

    @Builder.Default
    private int pageSize = 10;
}
