package com.example.delivery_burgers.mapper;

import com.example.delivery_burgers.dto.CardDto;
import com.example.delivery_burgers.model.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto toDto(Card card);

    Card toEntity(CardDto dto);

    List<CardDto> toDto(List<Card> cards);

    List<Card> toEntity(List<CardDto> cards);
}
