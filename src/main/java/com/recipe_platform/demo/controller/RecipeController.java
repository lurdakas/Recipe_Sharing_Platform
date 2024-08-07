package com.recipe_platform.demo.controller;


import com.recipe_platform.demo.DTO.RecipeDto;

import com.recipe_platform.demo.model.Ingredient;
import com.recipe_platform.demo.model.Recipe;
import com.recipe_platform.demo.services.IngredientService;

import com.recipe_platform.demo.services.RecipeService;
import com.recipe_platform.demo.repository.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {


    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    @Autowired
    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }


    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        try {
            List<Recipe> recipes = (List<Recipe>) recipeService.findAll();
            recipes.forEach(recipe -> System.out.println(recipe)); // Log recipes
            return ResponseEntity.ok(recipes);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipesById(@PathVariable Long id) {
        Optional<Recipe> recipes = recipeService.findById(id);
        if (recipes.isPresent()) {
            return ResponseEntity.ok(recipes.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @PostMapping
//    public Recipe createRecipe(@RequestBody RecipeDto recipeDto) {
//        return recipeService.createRecipe(recipeDto);
//    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeDto.getTitle());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setPrep_time(recipeDto.getPrepTime());
        recipe.setCook_time(recipeDto.getCookTime());
        recipe.setServings(recipeDto.getServings());

        List<Ingredient> ingredients = recipeDto.getIngredients().stream()
                .map(ingredientDto -> {
                    String ingredientName = ingredientDto.getName();
                    Optional<Ingredient> ingredientOpt = ingredientService.findByName(ingredientName);
                    if (ingredientOpt.isPresent()) {
                        return ingredientOpt.get();
                    } else {
                        Ingredient ingredient = new Ingredient();
                        ingredient.setName(ingredientName);
                        return ingredientService.save(ingredient);
                    }
                }).collect(Collectors.toList());

        recipe.getIngredients().addAll(ingredients);

        Recipe createdRecipe = recipeService.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        Optional<Recipe> existingRecipe = recipeService.findById(id);
        if (existingRecipe.isPresent()) {
            Recipe updatedRecipe = existingRecipe.get();
            updatedRecipe.setTitle(recipe.getTitle());
            updatedRecipe.setDescription(recipe.getDescription());
            updatedRecipe.setInstructions(recipe.getInstructions());
            updatedRecipe.setPrep_time(recipe.getPrep_time());
            updatedRecipe.setCook_time(recipe.getCook_time());
            updatedRecipe.setServings(recipe.getServings());
            updatedRecipe.setIngredients(recipe.getIngredients());
            recipeService.save(updatedRecipe);
            return ResponseEntity.ok(updatedRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
    }


}
