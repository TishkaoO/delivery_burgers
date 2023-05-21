package com.example.delivery_burgers.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private int paymentAmount;

    @OneToMany
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private List<OrderEntity> orders = new ArrayList<>();
}
