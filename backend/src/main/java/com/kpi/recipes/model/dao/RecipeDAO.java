package com.kpi.recipes.model.dao;

import com.kpi.recipes.model.Recipe;
import com.kpi.recipes.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO extends ListCrudRepository<Recipe, Long> {
    List<Recipe> findByUser(User user);
    Optional<Recipe> findByTitleIgnoreCase(String title);
}
