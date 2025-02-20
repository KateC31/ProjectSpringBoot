package com.Inti.backend.service;

import com.Inti.backend.model.Products;
import com.Inti.backend.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductsService{

        @Autowired
        private IProductsRepository productsRepository;

        @Override
        public List<Products> getProducts() {
            List<Products> usersList = productsRepository.findAll();
            return usersList;
        }

        @Override
        public void saveProduct(Products product) {
            productsRepository.save(product);
        }

        @Override
        public void deleteProduct(Long id) {
            productsRepository.deleteById(id);
        }

        @Override
        public Products findProduct(Long id) {
            Products product = productsRepository.findById(id).orElse(null);
            return product;
        }

        public void editProduct(Long id, Products product){
            Products foundedProduct = productsRepository.findById(id).orElse(null);
            if (foundedProduct != null){
                foundedProduct.setName(product.getName());
                foundedProduct.setQuantity(product.getQuantity());
                foundedProduct.setPrice(product.getPrice());
                foundedProduct.setDescription(product.getDescription());
                foundedProduct.setImage(product.getImage());
                productsRepository.save(foundedProduct);
            } else {
                System.out.println("User was not found: " + id);
            }
        }
}
