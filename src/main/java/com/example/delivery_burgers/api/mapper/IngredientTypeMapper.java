package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.IngredientTypeDto;
import com.example.delivery_burgers.store.entity.IngredientType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientTypeMapper {

    IngredientTypeDto toDto(IngredientType ingredientType);

    IngredientType toEntity(IngredientTypeDto dto);

    List<IngredientTypeDto> toDto(List<IngredientType> ingredientTypes);

    List<IngredientType> toEntity(List<IngredientTypeDto> dtos);
}
