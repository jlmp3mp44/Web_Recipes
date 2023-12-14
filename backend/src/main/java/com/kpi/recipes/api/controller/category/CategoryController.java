package com.kpi.recipes.api.controller.category;

import com.kpi.recipes.api.exception.CategoryAlreadyExistException;
import com.kpi.recipes.api.exception.UserAlreadyExistException;
import com.kpi.recipes.api.model.CategoryBody;
import com.kpi.recipes.api.model.RegistrationBody;
import com.kpi.recipes.model.Category;
import com.kpi.recipes.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/categories/add")
    public ResponseEntity registerUser(@Valid @RequestBody CategoryBody categoryBody) {
        try {
            categoryService.addCategory(categoryBody);
            return ResponseEntity.ok().build();
        } catch (CategoryAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
