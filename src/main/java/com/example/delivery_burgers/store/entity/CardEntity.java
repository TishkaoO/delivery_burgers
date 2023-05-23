package com.example.delivery_burgers.store.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_owner")
    private String nameOwner;

    @Column(name = "card_number")
    private String number;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    private String cvv;

    private double balance;
}
