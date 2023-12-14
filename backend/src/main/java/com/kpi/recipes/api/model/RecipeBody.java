package com.kpi.recipes.api.model;

import com.kpi.recipes.model.Category;
import com.kpi.recipes.model.IngredientRecipe;
import com.kpi.recipes.model.MenuRecipe;
import com.kpi.recipes.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecipeBody {
    private User user;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Long time;
    @NotNull
    private Long calorie;
    @NotNull
    private Category category;
    @NotNull
    private List<IngredientRecipe> ingredientRecipes;
    @NotNull
    private MenuRecipe menuRecipe;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getCalorie() {
        return calorie;
    }

    public void setCalorie(Long calorie) {
        this.calorie = calorie;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<IngredientRecipe> getIngredientRecipes() {
        return ingredientRecipes;
    }

    public void setIngredientRecipes(List<IngredientRecipe> ingredientRecipes) {
        this.ingredientRecipes = ingredientRecipes;
    }

    public MenuRecipe getMenuRecipe() {
        return menuRecipe;
    }

    public void setMenuRecipe(MenuRecipe menuRecipe) {
        this.menuRecipe = menuRecipe;
    }
}
