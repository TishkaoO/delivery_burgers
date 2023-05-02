package com.example.delivery_burgers.model;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class BurgerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(name = "order_id")
    private Long id;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @OneToMany(mappedBy = "burgerOrder")
    private List<Burger> burgers;

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "is_ready")
    private boolean isReady;
}
