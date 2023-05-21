package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.MenuDto;
import com.example.delivery_burgers.store.entity.Menu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    MenuDto toDto(Menu menu);

    Menu toEntity(MenuDto dto);

    List<MenuDto> toDto(List<Menu> menus);

    List<Menu> toEntity(List<MenuDto> dtos);
}
