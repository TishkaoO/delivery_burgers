package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class BurgerDto {

    private String name;

    private String description;

    private double price;

    private boolean isSpicy;

    private List<Ingredient> ingredients;
}
