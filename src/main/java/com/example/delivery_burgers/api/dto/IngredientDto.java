package com.example.delivery_burgers.api.dto;

import lombok.Data;

@Data
public class IngredientDto {

    private String name;

    private double price;

    private IngredientTypeDto type;
}
