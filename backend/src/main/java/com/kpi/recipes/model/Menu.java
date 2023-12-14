package com.kpi.recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Lob
    @Column(name = "description", nullable = false)
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "menu", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<MenuRecipe> menuRecipes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
