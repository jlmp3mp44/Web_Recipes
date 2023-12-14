package com.kpi.recipes.service;

import com.kpi.recipes.model.Ingredient;
import com.kpi.recipes.model.dao.IngredientDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientDAO ingredientDAO;

    public IngredientService(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }
    public List<Ingredient> getIngredients(){
        return ingredientDAO.findAll();
    }
}
