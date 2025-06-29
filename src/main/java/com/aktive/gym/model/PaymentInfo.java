package com.aktive.gym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "payment_info")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    private String cardName;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
