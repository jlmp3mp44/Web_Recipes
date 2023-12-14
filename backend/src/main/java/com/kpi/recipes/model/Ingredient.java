package com.kpi.recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Long price;
    @JsonIgnore
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<IngredientRecipe> ingredientRecipe  = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<IngredientRecipe> getRecipeIngredient() {
        return ingredientRecipe;
    }

    public void setRecipeIngredient(List<IngredientRecipe> ingredientRecipe) {
        this.ingredientRecipe = ingredientRecipe;
    }
}
