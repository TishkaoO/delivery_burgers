package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Burger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerOrderDto {

    private String deliveryAddress;

    private List<Burger> burgers;

    private LocalDateTime creationDate = LocalDateTime.now();

    private boolean isReady;

}
