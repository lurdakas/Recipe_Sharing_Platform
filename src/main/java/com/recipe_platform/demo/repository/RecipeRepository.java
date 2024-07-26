package com.recipe_platform.demo.repository;

import com.recipe_platform.demo.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}