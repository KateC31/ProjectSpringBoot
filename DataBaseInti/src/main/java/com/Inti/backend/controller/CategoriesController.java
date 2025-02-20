package com.Inti.backend.controller;

import com.Inti.backend.model.Categories;
import com.Inti.backend.service.CategoriesService;
import com.Inti.backend.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Categories")
public class CategoriesController {

    @Autowired
    ICategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {

        this.categoriesService = categoriesService;

    }

    @GetMapping
    public List<Categories> getAllCategories() {
        return this.categoriesService.getCategories();
    }

    @PostMapping
    public void createCategories(@RequestBody Categories categorie){
        categoriesService.saveCategory(categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public Categories getCategoryById(@PathVariable Long id) {
        return categoriesService.findCategories(id);
    }
}


