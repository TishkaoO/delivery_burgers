package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Burger;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BurgerOrderDto {

    private String deliveryAddress;

    private List<Burger> burgers;

    private LocalDateTime creationDate = LocalDateTime.now();

    private boolean isReady;
}
