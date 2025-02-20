package com.Inti.backend.repository;

import com.Inti.backend.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriesRepository extends JpaRepository<Categories,Long>{


}
