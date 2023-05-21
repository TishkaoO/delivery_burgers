package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.IngredientDto;
import com.example.delivery_burgers.store.entity.IngredientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDto toDto(IngredientEntity ingredient);

    IngredientEntity toEntity(IngredientDto dto);


    List<IngredientDto> toDto(List<IngredientEntity> ingredients);

    List<IngredientEntity> toEntity(List<IngredientDto> dtos);
}
