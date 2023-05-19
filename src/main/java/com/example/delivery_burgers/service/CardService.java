package com.example.delivery_burgers.service;

import com.example.delivery_burgers.dto.CardDto;
import com.example.delivery_burgers.mapper.CardMapper;
import com.example.delivery_burgers.model.Card;
import com.example.delivery_burgers.repository.CardRepository;
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

    public CardDto update(Card card) {
        Card findCardAndUpdate = cardRepository.findById(card.getId())
                .map(entity -> Card.builder()
                        .balance(card.getBalance())
                        .build())
                .orElseThrow(() -> {
                    log.info("This card with id: " + card.getId() + " is not exists!");
                    return new NoSuchElementException("Card is not exists");
                });
        return cardMapper.toDto(findCardAndUpdate);
    }

    public Card getCardByCardNumber(String number) {
        Card findCard = cardRepository.findByNumber(number).orElseThrow(() -> {
            log.info("This card with card number: " + number + " is not exists!");
            return new NoSuchElementException("Card is not exists");
        });
        return findCard;
    }
}
