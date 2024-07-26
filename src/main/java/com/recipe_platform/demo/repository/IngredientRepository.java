package com.recipe_platform.demo.repository;

import com.recipe_platform.demo.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
