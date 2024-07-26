package com.recipe_platform.demo.model;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "Recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "recipe_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "prep_time")
    private int prep_time;

    @Column(name = "cook_time")
    private int cook_time;

    @Column(name = "servings")
    private int servings;



}
