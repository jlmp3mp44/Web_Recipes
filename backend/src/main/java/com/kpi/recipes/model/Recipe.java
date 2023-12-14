package com.kpi.recipes.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Recipe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
        @Column(name = "title", length = 255, nullable = false)
        private String title;
        @Column(name = "description", length = 255, nullable = false)
        private String description;
        @Column(name = "time", nullable = false)
        private Long time;
        @Column(name = "calorie", nullable = false)
        private Long calorie;
        @ManyToOne
        @JoinColumn(name = "category_id", nullable = true)
        private Category category;


        @ManyToOne
        @JoinColumn(name = "menuRecipeId", insertable = false, updatable = false)

        private MenuRecipe menuRecipe;


    public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getCalorie() {
        return calorie;
    }

    public void setCalorie(Long calorie) {
        this.calorie = calorie;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MenuRecipe getMenuRecipe() {
        return menuRecipe;
    }

    public void setMenuRecipe(MenuRecipe menuRecipe) {
        this.menuRecipe = menuRecipe;
    }
}
