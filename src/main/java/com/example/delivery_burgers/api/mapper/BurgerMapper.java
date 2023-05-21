package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.BurgerDto;
import com.example.delivery_burgers.store.entity.BurgerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BurgerMapper {

    BurgerDto toDto(BurgerEntity burger);

    BurgerEntity toEntity(BurgerDto dto);

    List<BurgerDto> toDto(List<BurgerEntity> burger);

    List<BurgerEntity> toEntity(List<BurgerDto> burger);
}
