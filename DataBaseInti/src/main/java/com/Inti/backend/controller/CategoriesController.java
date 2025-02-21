package com.Inti.backend.controller;

import com.Inti.backend.model.Categories;
import com.Inti.backend.service.CategoriesService;
import com.Inti.backend.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
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
    public ResponseEntity<String> createCategories(@RequestBody Categories categorie) {
        categoriesService.saveCategory(categorie);
        return ResponseEntity.ok("Category created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted");
    }

    @GetMapping("/{id}")
    public Categories getCategoryById(@PathVariable Long id) {
        return categoriesService.findCategories(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Categories category) {
        categoriesService.editCategory(id, category);
        return ResponseEntity.ok("Category updated");
    }
}


