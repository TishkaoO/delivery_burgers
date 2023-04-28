package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.IngredientType;
import lombok.Data;

import java.util.List;

@Data
public class IngredientDto {

    private String name;

    private double price;

    private IngredientType type;
}
