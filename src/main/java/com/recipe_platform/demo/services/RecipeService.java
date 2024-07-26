package com.recipe_platform.demo.services;


import com.recipe_platform.demo.model.Recipe;
import com.recipe_platform.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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




}
