package com.example.delivery_burgers.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Card {

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Payment> payments;
}
