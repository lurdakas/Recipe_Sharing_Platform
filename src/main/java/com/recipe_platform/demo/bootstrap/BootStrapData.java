package com.recipe_platform.demo.bootstrap;

import com.recipe_platform.demo.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class BootStrapData implements CommandLineRunner {
    private final RecipeRepository recipeRepository;

    private final Logger logger = LoggerFactory.getLogger(BootStrapData.class);

    public BootStrapData(RecipeRepository authorRepository) {
        this.recipeRepository = authorRepository;
    }



    @Override
    public void run(String... args)  {
        System.out.println("hello");
        System.out.println(recipeRepository.findAll());


    }
}
