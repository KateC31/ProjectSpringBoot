package com.Inti.backend.repository;

import com.Inti.backend.model.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductsRepository extends JpaRepository<OrderProducts, Long> {
}
