package com.recipe_platform.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RecipeDto {

    private long id;
    private String title;
    private String description;
    private String instructions;

    private int prep_time;
    private int cook_time;
    private int servings;
    private List<IngredientDto> ingredients;

    // Constructor or setters to populate ingredients

}
