package com.kpi.recipes.service;

import com.kpi.recipes.api.exception.CategoryAlreadyExistException;
import com.kpi.recipes.api.exception.RecipeAlreadyExistException;
import com.kpi.recipes.api.model.CategoryBody;
import com.kpi.recipes.api.model.RecipeBody;
import com.kpi.recipes.model.Category;
import com.kpi.recipes.model.Recipe;
import com.kpi.recipes.model.User;
import com.kpi.recipes.model.dao.CategoryDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    public List<Category> getCategories(){
        return categoryDAO.findAll();
    }
    public Category addCategory(CategoryBody categoryBody) throws CategoryAlreadyExistException {
        if (categoryDAO.findAllByName(categoryBody.getName()).isPresent()) {
            throw new CategoryAlreadyExistException();
        }

        Category category =  new Category();
        category.setName(categoryBody.getName());
        category.setDescription(categoryBody.getDescription());
        category.setRecipes(categoryBody.getRecipes());
        category =  categoryDAO.save(category);
        return category;
    }
}
