package com.Inti.backend.repository;

import com.Inti.backend.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {

}
