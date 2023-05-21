package com.example.delivery_burgers.api.mapper;

import com.example.delivery_burgers.api.dto.CardDto;
import com.example.delivery_burgers.store.entity.CardEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto toDto(CardEntity card);

    CardEntity toEntity(CardDto dto);

    List<CardDto> toDto(List<CardEntity> cards);

    List<CardEntity> toEntity(List<CardDto> cards);
}
