package com.Inti.backend.service;
import com.Inti.backend.model.Categories;

import java.util.List;

public interface ICategoriesService {
    public List<Categories> getCategories();

    public void saveCategory(Categories category);

    public void deleteCategory(Long id);

    public Categories findCategories(Long id);

    public void editCategory(Long id, Categories category);
}
