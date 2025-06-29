package com.aktive.gym.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoRequest {

    private String cardName;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
