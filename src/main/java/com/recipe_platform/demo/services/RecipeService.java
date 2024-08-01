package com.recipe_platform.demo.services;


import com.recipe_platform.demo.DTO.RecipeDto;
import com.recipe_platform.demo.model.Ingredient;
import com.recipe_platform.demo.model.Recipe;
import com.recipe_platform.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Iterable<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }

    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public void deleteById(Long id){
        recipeRepository.deleteById(id);
    }


    public Recipe createRecipe(RecipeDto createRecipeDto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(createRecipeDto.getTitle());
        recipe.setDescription(createRecipeDto.getDescription());
        recipe.setInstructions(createRecipeDto.getInstructions());
        recipe.setPrep_time(createRecipeDto.getPrep_time());
        recipe.setCook_time(createRecipeDto.getCook_time());
        recipe.setServings(createRecipeDto.getServings());

        List<Ingredient> ingredients = createRecipeDto.getIngredients()
                .stream()
                .map(ingredientDto -> {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(ingredientDto.getName());
                    ingredient.setRecipe(recipe);
                    // Assuming bidirectional relationship
                    return ingredient;
                })
                .collect(Collectors.toList());

        recipe.setIngredients(ingredients);
        return recipeRepository.save(recipe);
    }
}
