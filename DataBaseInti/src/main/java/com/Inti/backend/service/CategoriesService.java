package com.Inti.backend.service;

import com.Inti.backend.model.Categories;
import com.Inti.backend.repository.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private ICategoriesRepository categoriesRepository;

    @Override
    public List<Categories> getCategories() {
        List<Categories> categoriesList = categoriesRepository.findAll();
        return categoriesList;
    }

    @Override
    public void saveCategory(Categories category) {
        categoriesRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoriesRepository.deleteById(id);
    }

    @Override
    public Categories findCategories(Long id) {
        Categories category = categoriesRepository.findById(id).orElse(null);
        return category;
    }

    @Override
    public void editCategory(Long id, Categories category) {
        Categories foundedCategory = categoriesRepository.findById(id).orElse(null);
        if (foundedCategory != null) {
            foundedCategory.setName(category.getName());
            foundedCategory.setDescription(category.getDescription());
            foundedCategory.setImageCover(category.getImageCover());
            foundedCategory.setImageHover(category.getImageHover());
            categoriesRepository.save(foundedCategory);
        } else {
            System.out.println("Category not found: " + id);
        }
    }
}
