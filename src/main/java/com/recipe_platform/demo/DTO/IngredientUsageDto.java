package com.recipe_platform.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientUsageDto {
    private long id;
    private String name;
    private int usageCount;

    public IngredientUsageDto(long id, String name, int usageCount) {
        this.id = id;
        this.name = name;
        this.usageCount = usageCount;
    }
}