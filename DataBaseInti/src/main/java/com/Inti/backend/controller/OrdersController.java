package com.Inti.backend.controller;

import com.Inti.backend.model.Orders;
import com.Inti.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Orders")
public class OrdersController {
    OrdersService OrdersService;
    @Autowired
    public OrdersController(OrdersService ordersService) {

        this.OrdersService = ordersService;

    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return this.OrdersService.getOrders();
    }

    @PostMapping
    public void createOrders(@RequestBody Orders order){
        OrdersService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void DeleteOrder(@PathVariable Long id){
        OrdersService.deleteOrder(id);

    }

    @PutMapping("/{id}")
    public void editOrder(@PathVariable Long id, @RequestBody Orders order){
        OrdersService.editOrder(id, order);
    }

}
