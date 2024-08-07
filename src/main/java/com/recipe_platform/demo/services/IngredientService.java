package com.recipe_platform.demo.services;

import com.recipe_platform.demo.DTO.IngredientDto;
import com.recipe_platform.demo.DTO.IngredientUsageDto;
import com.recipe_platform.demo.model.Ingredient;
import com.recipe_platform.demo.repository.IngredientRepository;
import com.recipe_platform.demo.repository.RecipeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

@Getter
@Setter
@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;



    public Iterable<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Long id){
        return ingredientRepository.findById(id);
    }

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Optional<Ingredient> findByName(String name) { return ingredientRepository.findByName(name);
    }

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }



    public List<IngredientUsageDto> getIngredientUsage() {
        // Fetch all ingredients and count their occurrences in recipes
        Iterable<Ingredient> ingredientsIterable = ingredientRepository.findAll();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientsIterable.forEach(ingredients::add);

        return ingredients.stream()
                .map(ingredient -> new IngredientUsageDto(
                        ingredient.getId(),
                        ingredient.getName(),
                        recipeRepository.countByIngredientsId(ingredient.getId())
                ))
                .collect(Collectors.toList());
    }



}
