package com.kpi.recipes.api.controller.Ingredient;

import com.kpi.recipes.model.Ingredient;
import com.kpi.recipes.model.IngredientRecipe;
import com.kpi.recipes.service.IngredientRecipeService;
import com.kpi.recipes.service.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipe/ingredientRecipe")
public class IngredientRecipeController {
    private IngredientRecipeService ingredientService;

    public IngredientRecipeController(IngredientRecipeService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientRecipe> getIngredients(){
        return ingredientService.getIngredients();
    }
}