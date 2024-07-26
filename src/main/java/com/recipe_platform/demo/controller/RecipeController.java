package com.recipe_platform.demo.controller;


import com.recipe_platform.demo.model.Recipe;
import com.recipe_platform.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {


    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public Iterable<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipesbyId(@PathVariable Long id){
        Optional<Recipe> recipes = recipeService.findById(id);
        if(recipes.isPresent()){
            return ResponseEntity.ok(recipes.get());

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return recipeService.save(recipe);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeDetails){
        Optional<Recipe> recipe = recipeService.findById(id);
        if(recipe.isPresent()) {
            Recipe updateRecipe = recipe.get();
            updateRecipe.setTitle(recipeDetails.getTitle());
            updateRecipe.setDescription(recipeDetails.getDescription());
            updateRecipe.setInstructions(recipeDetails.getInstructions());
            updateRecipe.setServings(recipeDetails.getServings());
            updateRecipe.setCook_time(recipeDetails.getCook_time());
            updateRecipe.setPrep_time(recipeDetails.getPrep_time());
            return ResponseEntity.ok(recipeService.save(updateRecipe));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
