package com.Inti.backend.model;

import jakarta.persistence.*;
import lombok.extern.java.Log;

@Entity

public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_orderProducts;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Orders order_id;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Products product_id;

    private Long quantity;

    public OrderProducts(Long id_orderProducts, Orders order_id, Products product_id, Long quantity) {
        this.id_orderProducts = id_orderProducts;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OrderProducts() {

    }

    public Long getId_orderProducts() {
        return id_orderProducts;
    }

    public void setId_orderProducts(Long id_orderProducts) {
        this.id_orderProducts = id_orderProducts;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
