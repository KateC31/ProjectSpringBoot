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
    private String imageCover;

    public String getImageHover() {
        return imageHover;
    }

    public void setImageHover(String imageHover) {
        this.imageHover = imageHover;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    private String imageHover;

    public Categories(Long id_categories, String name, String description, String imageCover, String imageHover) {
        this.id_categories = id_categories;
        this.name = name;
        this.description = description;
        this.imageCover = imageCover;
        this.imageHover = imageHover;
    }

    public Categories(String name, String description, String imageCover, String imageHover) {
        this.name = name;
        this.description = description;
        this.imageCover = imageCover;
        this.imageHover = imageHover;
    }

    public Categories() {

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
