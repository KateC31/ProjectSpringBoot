package com.Inti.backend.service;
import com.Inti.backend.model.Categories;

import java.util.List;

public interface ICategoriesService {
    public List<Categories> getCategories();

    public void saveCategorie(Categories categorie);

    public void deleteCategorie(Long id);

    public Categories findCategorie(Long id);
}
