package com.Inti.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_categories;
    private String name;
    private String description;

    public Categories(Long id_categories, String name, String description) {
        this.id_categories = id_categories;
        this.name = name;
        this.description = description;

    }

    public Long getId_categories() {
        return id_categories;
    }

    public void setId_categories(Long id_categories) {
        this.id_categories = id_categories;
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
