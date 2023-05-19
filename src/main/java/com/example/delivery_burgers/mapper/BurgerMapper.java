package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.BurgerDto;
import com.example.delivery_burgers.model.Burger;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BurgerMapper {

    BurgerDto toDto(Burger burger);

    Burger toEntity(BurgerDto dto);

    List<BurgerDto> toDto(List<Burger> burger);

    List<Burger> toEntity(List<BurgerDto> burger);
}
