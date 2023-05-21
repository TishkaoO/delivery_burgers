package com.example.delivery_burgers.api.dto;

import com.example.delivery_burgers.store.entity.BurgerEntity;
import lombok.Data;

import java.util.List;

@Data
public class MenuDto {

    private String nameMenu;

    private List<BurgerEntity> burgers;
}
