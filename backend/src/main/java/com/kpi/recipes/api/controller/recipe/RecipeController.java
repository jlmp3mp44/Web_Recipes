package com.kpi.recipes.api.controller.recipe;
import com.kpi.recipes.api.exception.RecipeAlreadyExistException;
import com.kpi.recipes.api.model.RecipeBody;
import com.kpi.recipes.model.Recipe;
import com.kpi.recipes.model.User;
import com.kpi.recipes.service.AuthorizationService;
import com.kpi.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@CrossOrigin()
public class RecipeController {
    private RecipeService recipeService;
    private AuthorizationService authorizationService;
    @GetMapping
    public List<Recipe> getRecipes(@AuthenticationPrincipal User user){
        return recipeService.getRecipes(user);
    }


    public RecipeController(RecipeService recipeService, AuthorizationService authorizationService) {
        this.recipeService = recipeService;
        this.authorizationService = authorizationService;
    }
    @PostMapping("/add")
    public ResponseEntity addRecipe(@Valid @RequestBody RecipeBody recipeBody) {
        User user = authorizationService.getCurrentUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        try {
            recipeService.addRecipes(user, recipeBody);
            return ResponseEntity.ok().build();
        } catch (RecipeAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
