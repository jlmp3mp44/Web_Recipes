package com.kpi.recipes.service;

import com.kpi.recipes.api.exception.RecipeAlreadyExistException;
import com.kpi.recipes.api.model.RecipeBody;
import com.kpi.recipes.model.Category;
import com.kpi.recipes.model.Recipe;
import com.kpi.recipes.model.User;
import com.kpi.recipes.model.dao.CategoryDAO;
import com.kpi.recipes.model.dao.RecipeDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeDAO recipeDAO;

    public RecipeService(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }
    public List<Recipe> getRecipes(User user){
        return recipeDAO.findByUser(user);
    }
    public Recipe addRecipes(User user, RecipeBody recipeBody) throws RecipeAlreadyExistException {
        if (recipeDAO.findByTitleIgnoreCase(recipeBody.getTitle()).isPresent()) {
            throw new RecipeAlreadyExistException();
        }

        Recipe recipe =  new Recipe();
        recipe.setUser(user);
        recipe.setTitle(recipeBody.getTitle());
        recipe.setMenuRecipe(recipeBody.getMenuRecipe());
        recipe.setCalorie(recipeBody.getCalorie());
        recipe.setCategory(recipeBody.getCategory());
        recipe.setDescription(recipeBody.getDescription());
        recipe.setTime(recipeBody.getTime());
        recipe =  recipeDAO.save(recipe);
        return recipe;
    }
}
