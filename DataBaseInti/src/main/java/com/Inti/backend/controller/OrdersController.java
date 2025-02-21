package com.Inti.backend.controller;

import com.Inti.backend.model.OrderProducts;
import com.Inti.backend.model.Orders;
import com.Inti.backend.model.Products;
import com.Inti.backend.model.Users;
import com.Inti.backend.service.OrdersService;
import com.Inti.backend.service.ProductService;
import com.Inti.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    UsersService usersService;

    @Autowired
    ProductService productService;

    public OrdersController(OrdersService ordersService, UsersService usersService, ProductService productService) {
        this.productService = productService;
        this.ordersService = ordersService;
        this.usersService = usersService;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return this.ordersService.getOrders();
    }

    @PostMapping
    public ResponseEntity<String> createOrders(@RequestBody Orders order) {
        if (order.getUser() == null || order.getUser().getId_user() == null) {
            return ResponseEntity.badRequest().body("User ID is required");
        }

        // Buscar usuario en la BD
        Users user = usersService.findUser(order.getUser().getId_user());
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid User ID");
        }
        order.setUser(user); // Asignar el usuario existente

        // Verificar que los productos existen en la BD
        for (OrderProducts orderProduct : order.getOrderProducts()) {
            if (orderProduct.getProduct_id() == null || orderProduct.getProduct_id().getId_product() == null) {
                return ResponseEntity.badRequest().body("Product ID is required");
            }

            Products product = productService.findProduct(orderProduct.getProduct_id().getId_product());
            if (product == null) {
                return ResponseEntity.badRequest().body("Invalid Product ID: " + orderProduct.getProduct_id().getId_product());
            }

            orderProduct.setProduct_id(product); // Asignar el producto existente
            orderProduct.setOrder_id(order); // Relacionar el producto con la orden
        }

        ordersService.saveOrder(order);
        return ResponseEntity.ok("Order created successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteOrder(@PathVariable Long id){
        ordersService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }
}
