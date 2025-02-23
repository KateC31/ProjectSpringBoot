package com.Inti.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Inti.backend.model.Categories;
import java.util.Optional;

@Repository
public interface ICategoriesRepository extends JpaRepository<Categories,Long> {
    Optional<Categories> findByName(String name);
}
