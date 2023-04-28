package com.example.delivery_burgers.model;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "burgers")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(name = "burger_id")
    private Long id;

    private String name;

    private String description;

    private double price;

    @Column(name = "is_spicy")
    private boolean isSpicy;

    @OneToMany(mappedBy = "burger")
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private BurgerOrder burgerOrder;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
