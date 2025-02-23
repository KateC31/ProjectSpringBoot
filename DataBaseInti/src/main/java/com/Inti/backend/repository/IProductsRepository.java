package com.Inti.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Inti.backend.model.Categories;
import com.Inti.backend.model.Products;

@Repository
public interface IProductsRepository extends JpaRepository<Products, Long> {
    boolean existsByNameAndCategory(String name, Categories category);
}
