package com.recipe_platform.demo.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
//@Getter
//@Setter

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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();






    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", prep_time=" + prep_time +
                ", cook_time=" + cook_time +
                ", servings=" + servings +
                ", ingredients=" + ingredients +
                '}';
    }
}
