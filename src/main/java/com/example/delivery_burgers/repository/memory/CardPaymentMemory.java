package com.example.delivery_burgers.repository.memory;

import com.example.delivery_burgers.model.CardPayment;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public interface CardPaymentMemory {

    boolean addPayment(CardPayment payment);

    Optional<CardPayment> getPaymentById(long id);

    /*
    возвращает список платежей, связанных с указанным номером карты.
     */
    Optional<CardPayment> getPaymentsByCardNumber(String cardNumber);

    /*
    возвращает список платежей, совершенных в указанную дату.
     */
    Optional<CardPayment> getPaymentsByDate(Date date);

    /*
    возвращает общую сумму платежей, связанных с указанным номером карты.
     */
    double getTotalAmountByCardNumber(String cardNumber);

    Collection<CardPayment> findAll();
}
