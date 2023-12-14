package com.kpi.recipes.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Menus_Recipes")
public class MenuRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {return menu; }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Recipe getRecipes() {
        return recipe;
    }

    public void setRecipes(Recipe recipe) {
        this.recipe = recipe;
    }
}

