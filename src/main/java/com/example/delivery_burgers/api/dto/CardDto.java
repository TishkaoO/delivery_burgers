package com.example.delivery_burgers.api.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class CardDto {

    @NotNull(message = "Expiry name owner is required")
    private String nameOwner;

    @NotNull(message = "Expiry card number is required")
    private String cardNumber;

    @NotNull(message = "Expiry date is required")
    @Future(message = "Expiry date must be in the future")
    private LocalDateTime expiryDate;

    @NotNull(message = "Expiry cvv is required")
    private String cvv;

    private double balance;
}
