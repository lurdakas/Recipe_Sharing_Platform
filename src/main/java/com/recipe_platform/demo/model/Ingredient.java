package com.recipe_platform.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

//@Getter
//@Setter

public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "ingredient_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "recipe_id", insertable = false, updatable = false)
    private long recipe_id;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
