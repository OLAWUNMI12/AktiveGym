package com.aktive.gym.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEmailRequest {

    @NotBlank(message = "Message is mandatory")
    private String message;

    @NotBlank(message = "Message is mandatory")
    private String notificationType;

    @NotBlank(message = "Subject is mandatory")
    private String subject;

}
