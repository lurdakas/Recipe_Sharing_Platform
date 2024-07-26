package com.recipe_platform.demo.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = " Ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "ingredient_id")
    private long id;

    @Column(name = "name")
    private String name;
}
