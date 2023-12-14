package com.kpi.recipes.api.model;

import com.kpi.recipes.model.Recipe;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CategoryBody {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private List<Recipe> recipes =  new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
