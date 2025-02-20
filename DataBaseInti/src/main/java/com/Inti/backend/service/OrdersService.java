package com.Inti.backend.service;

import com.Inti.backend.model.Orders;
import com.Inti.backend.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements  IOrdersService {

     @Autowired
     private IOrdersRepository ordersRepository;

    @Override
    public List<Orders> getOrders() {
        List<Orders> orders = ordersRepository.findAll();
        return orders;
    }

    @Override
    public void saveOrder(Orders order) {
        ordersRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Orders findOrder(Long id) {
        Orders order = ordersRepository.findById(id).orElse(null);
        return order;
    }

    public void editOrder(Long id, Orders order) {
        Orders foundedOrder = ordersRepository.findById(id).orElse(null);
        if (foundedOrder != null) {
            foundedOrder.setState(order.getState());
        } else {
            System.out.println("Order not found: " + id);
        }
    }
}
