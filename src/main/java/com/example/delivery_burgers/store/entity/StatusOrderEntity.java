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
@Table(name = "status_order")
public class StatusOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany
    @JoinColumn(name = "status_order_id", referencedColumnName = "id")
    private List<OrderEntity> orders = new ArrayList<>();
}
