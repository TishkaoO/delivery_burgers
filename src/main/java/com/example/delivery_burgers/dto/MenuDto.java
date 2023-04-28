package com.example.delivery_burgers.dto;

import com.example.delivery_burgers.model.Burger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private String nameMenu;

    private List<Burger> burgers;
}
