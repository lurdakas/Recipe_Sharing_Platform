package com.recipe_platform.demo.repository;

import com.recipe_platform.demo.model.Recipe;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @EntityGraph(attributePaths = "ingredients")
    List<Recipe> findAll();

    @Query("SELECT COUNT(r) FROM Recipe r JOIN r.ingredients i WHERE i.id = :ingredientId")
    int countByIngredientsId(@Param("ingredientId") Long ingredientId);
}