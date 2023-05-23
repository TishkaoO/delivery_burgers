package com.example.delivery_burgers.api.service;

import com.example.delivery_burgers.api.dto.AscDto;
import com.example.delivery_burgers.api.dto.OrderDto;
import com.example.delivery_burgers.api.mapper.OrderMapper;
import com.example.delivery_burgers.store.entity.CardEntity;
import com.example.delivery_burgers.store.entity.OrderEntity;
import com.example.delivery_burgers.store.repository.CustomerRepository;
import com.example.delivery_burgers.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final OrderService orderService;
    private final CardService cardService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
//    public AscDto payToTheOrder(Long orderId) {
//        //открыл заказ
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new IllegalArgumentException("Card is not exists"));
//        //узнать какому юзеру принадлежит этот номер заказ
//        // и как раз с этого юзера списать лаве
//        //нужно понять сумму заказа и после просто списать эту сумму с карты
//        // если сумма меньше 500 руб то предложить доплатить
//        // если отказывается то списываем сколько он сказал и возвращаем сообщение чтоб заплатил курьеру
//        // если больше то списать с карты эту сумму
//        OrderDto dto = orderMapper.toDto(order);
//        double sumPay = dto.getToPay();
//        if (sumPay < 500) {
//            //message
//        } else {
//            customerRepository.findById();
//                    //узнать какому юзеру принадлежит этот номер заказ
//            // и как раз с этого юзера списать лаве
//        }
//        if ()
//    }
//}
}
