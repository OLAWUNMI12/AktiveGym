package com.aktive.gym.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "payment_info")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    private String cardName;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
