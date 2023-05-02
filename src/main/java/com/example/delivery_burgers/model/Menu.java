package com.example.delivery_burgers.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "name_menu")
    private String nameMenu;

    @OneToMany(mappedBy = "menu")
    private List<Burger> burgers;
}
