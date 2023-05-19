package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.CardDto;
import com.example.delivery_burgers.dto.IngredientDto;
import com.example.delivery_burgers.model.Card;
import com.example.delivery_burgers.model.Ingredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDto toDto(Ingredient ingredient);

    Ingredient toEntity(IngredientDto dto);


    List<IngredientDto> toDto(List<Ingredient> ingredients);

    List<Ingredient> toEntity(List<IngredientDto> dtos);
}
