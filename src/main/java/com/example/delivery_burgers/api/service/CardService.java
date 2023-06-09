package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.CardDto;
import com.example.delivery_burgers.api.exceptions.BadRequestException;
import com.example.delivery_burgers.api.mapper.CardMapper;
import com.example.delivery_burgers.store.entity.CardEntity;
import com.example.delivery_burgers.store.entity.CustomerEntity;
import com.example.delivery_burgers.store.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CustomerService customerService;
    private final CardMapper cardMapper;

    public CardDto createCard(Long customerId, String nameOwner, String cardNumber, LocalDateTime expiryDate, String cvv) {
        CardEntity cardEntity = CardEntity.builder()
                .nameOwner(nameOwner)
                .cardNumber(cardNumber)
                .expiryDate(expiryDate)
                .balance(50)
                .cvv(cvv)
                .build();
        cardRepository.save(cardEntity);
        linkCardToCustomer(customerId, cardEntity.getId());
        return cardMapper.toDto(cardEntity);
    }

    public void saveCard(CardEntity entity) {
        cardRepository.save(entity);
    }

    public CardEntity getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new BadRequestException("card not found"));
    }

    private void linkCardToCustomer(Long customerId, Long cardId) {
        CustomerEntity customer = customerService.getCustomerByIdOrElseThrow(customerId);
        CardEntity card = getCardById(cardId);
        customer.getCards().add(card);
        cardRepository.save(card);
    }
}
