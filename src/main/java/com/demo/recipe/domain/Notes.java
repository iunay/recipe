package com.demo.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // oneToOne Relationship with Recipe
    @OneToOne
    private Recipe recipe;

    @Lob // Large objects
    private String recipeNotes;

}
