package com.recipe_platform.demo.repository;

import com.recipe_platform.demo.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}
