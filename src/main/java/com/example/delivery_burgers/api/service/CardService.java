package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.mapper.CardMapper;
import com.example.delivery_burgers.store.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

}
