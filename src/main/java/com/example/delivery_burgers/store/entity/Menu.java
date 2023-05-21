package com.example.delivery_burgers.store.entity;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<BurgerEntity> burgers = new ArrayList<>();
}
