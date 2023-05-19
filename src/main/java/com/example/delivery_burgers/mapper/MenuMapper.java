package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.IngredientTypeDto;
import com.example.delivery_burgers.dto.MenuDto;
import com.example.delivery_burgers.model.IngredientType;
import com.example.delivery_burgers.model.Menu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    MenuDto toDto(Menu menu);

    Menu toEntity(MenuDto dto);

    List<MenuDto> toDto(List<Menu> menus);

    List<Menu> toEntity(List<MenuDto> dtos);
}
