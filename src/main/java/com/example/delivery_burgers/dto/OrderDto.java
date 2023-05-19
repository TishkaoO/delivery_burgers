package com.example.delivery_burgers.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private String name;

    private int numberOrder;

    private List<BurgerDto> burgers;

    private LocalDateTime createdDate = LocalDateTime.now();

    private StatusOrderDto statusOrder;

    private PaymentDto payment;
}
