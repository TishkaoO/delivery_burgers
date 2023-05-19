package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.IngredientDto;
import com.example.delivery_burgers.dto.IngredientTypeDto;
import com.example.delivery_burgers.model.Ingredient;
import com.example.delivery_burgers.model.IngredientType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientTypeMapper {

    IngredientTypeDto toDto(IngredientType ingredientType);

    IngredientType toEntity(IngredientTypeDto dto);

    List<IngredientTypeDto> toDto(List<IngredientType> ingredientTypes);

    List<IngredientType> toEntity(List<IngredientTypeDto> dtos);
}
