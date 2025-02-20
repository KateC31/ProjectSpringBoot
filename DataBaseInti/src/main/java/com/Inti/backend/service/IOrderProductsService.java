package com.Inti.backend.service;
import com.Inti.backend.model.OrderProducts;

import java.util.List;

public interface IOrderProductsService {
    public List<OrderProducts> getOrderProduct();

    public void saveOrderProduct(OrderProducts orderproduct);

    public void deleteOrderProduct(Long id);

    public OrderProducts findOrderProduct(Long id);
}
