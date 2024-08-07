package com.recipe_platform.demo.controller;


import com.recipe_platform.demo.DTO.IngredientUsageDto;
import com.recipe_platform.demo.model.Ingredient;
import com.recipe_platform.demo.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {


    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientsById(@PathVariable Long id){
        Optional<Ingredient> ingredients = ingredientService.findById(id);
        if(ingredients.isPresent()){
            return ResponseEntity.ok(ingredients.get());

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usage")
    public List<IngredientUsageDto> getIngredientUsage() {
        return ingredientService.getIngredientUsage();
    }



    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.save(ingredient);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientDetails){
        Optional<Ingredient> ingredient = ingredientService.findById(id);
        if(ingredient.isPresent()) {
            Ingredient updateIngredient = ingredient.get();
            updateIngredient.setName(ingredientDetails.getName());

            return ResponseEntity.ok(ingredientService.save(updateIngredient));
        }else{
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
