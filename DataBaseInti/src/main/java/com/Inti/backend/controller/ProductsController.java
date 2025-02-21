package com.Inti.backend.controller;

import com.Inti.backend.model.Products;
import com.Inti.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<String> saveProduct (@RequestBody Products product) {
        this.productService.saveProduct(product);
        return ResponseEntity.ok("Product created");
    }
}
