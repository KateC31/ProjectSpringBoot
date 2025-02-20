package com.Inti.backend.service;

import com.Inti.backend.model.Products;
import com.Inti.backend.model.Users;

import java.util.List;

public interface IProductsService {
    public List<Products> getProducts();

    public void saveProduct(Products product);

    public void deleteProduct(Long id);

    public Products findProduct(Long id);
}
