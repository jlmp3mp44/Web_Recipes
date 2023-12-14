package com.kpi.recipes.model.dao;

import com.kpi.recipes.model.Ingredient;
import org.springframework.data.repository.ListCrudRepository;

public interface IngredientDAO  extends ListCrudRepository<Ingredient, Long> {
}
