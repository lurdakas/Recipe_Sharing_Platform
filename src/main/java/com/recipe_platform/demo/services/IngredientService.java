package com.recipe_platform.demo.services;

import com.recipe_platform.demo.model.Ingredient;
import com.recipe_platform.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {



    @Autowired
    private IngredientRepository ingredientRepository;

    public Iterable<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Long id){
        return ingredientRepository.findById(id);
    }

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }


    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }



}
