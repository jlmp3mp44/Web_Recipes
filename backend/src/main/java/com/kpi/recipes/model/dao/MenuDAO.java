package com.kpi.recipes.model.dao;

import com.kpi.recipes.model.Menu;
import org.springframework.data.repository.ListCrudRepository;

public interface MenuDAO extends ListCrudRepository<Menu, Long> {
}
