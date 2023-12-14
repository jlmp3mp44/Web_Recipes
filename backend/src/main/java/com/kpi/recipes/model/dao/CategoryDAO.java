package com.kpi.recipes.model.dao;

import com.kpi.recipes.model.Category;
import com.kpi.recipes.model.Recipe;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO extends ListCrudRepository<Category, Long> {
    Optional<Category> findAllByName(String name);
}
