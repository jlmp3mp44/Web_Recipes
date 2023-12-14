package com.kpi.recipes.service;

import com.kpi.recipes.model.Ingredient;
import com.kpi.recipes.model.IngredientRecipe;
import com.kpi.recipes.model.dao.IngredientDAO;
import com.kpi.recipes.model.dao.IngridientRecipesDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientRecipeService {
    private IngridientRecipesDAO ingredientRecipeDAO;

    public IngredientRecipeService(IngridientRecipesDAO ingredientDAO) {
        this.ingredientRecipeDAO = ingredientDAO;
    }
    public List<IngredientRecipe> getIngredients(){
        return ingredientRecipeDAO.findAll();
    }
}
