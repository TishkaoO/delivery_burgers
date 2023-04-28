package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Burger;
import lombok.Data;

import java.util.List;

@Data
public class MenuDto {

    private String nameMenu;

    private List<Burger> burgers;
}
