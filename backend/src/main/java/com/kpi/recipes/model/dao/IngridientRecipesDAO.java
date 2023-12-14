package com.kpi.recipes.model.dao;

import com.kpi.recipes.model.Ingredient;
import com.kpi.recipes.model.IngredientRecipe;
import org.springframework.data.repository.ListCrudRepository;

public interface IngridientRecipesDAO extends ListCrudRepository<IngredientRecipe, Long> {
}
