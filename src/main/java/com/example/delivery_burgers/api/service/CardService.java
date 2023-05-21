package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.CardDto;
import com.example.delivery_burgers.api.mapper.CardMapper;
import com.example.delivery_burgers.store.entity.CardEntity;
import com.example.delivery_burgers.store.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardDto update(CardEntity card) {
        CardEntity findCardAndUpdate = cardRepository.findById(card.getId())
                .map(entity -> CardEntity.builder()
                        .balance(card.getBalance())
                        .build())
                .orElseThrow(() -> {
                    log.info("This card with id: " + card.getId() + " is not exists!");
                    return new NoSuchElementException("Card is not exists");
                });
        return cardMapper.toDto(findCardAndUpdate);
    }

    public CardEntity getCardByCardNumber(String number) {
        CardEntity findCard = cardRepository.findByNumber(number).orElseThrow(() -> {
            log.info("This card with card number: " + number + " is not exists!");
            return new NoSuchElementException("Card is not exists");
        });
        return findCard;
    }
}
