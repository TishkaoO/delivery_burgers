package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerDto {

    private String name;

    private String description;

    private double price;

    private boolean isSpicy;

    private List<Ingredient> ingredients;
}
