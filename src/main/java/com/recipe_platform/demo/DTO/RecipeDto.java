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
    private String title;
    private String description;
    private String instructions;
    private int prepTime;
    private int cookTime;
    private int servings;
    private List<IngredientDto> ingredients;




}
