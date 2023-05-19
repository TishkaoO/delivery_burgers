package com.example.delivery_burgers.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "ingredient_types_id")
    private IngredientType type;

    @ManyToOne
    @JoinColumn(name = "burger_id")
    private Burger burger;
}
