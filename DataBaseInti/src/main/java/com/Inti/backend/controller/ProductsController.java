package com.Inti.backend.controller;

import com.Inti.backend.model.Categories;
import com.Inti.backend.model.Products;
import com.Inti.backend.service.CategoriesService;
import com.Inti.backend.service.IProductsService;
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

    @Autowired
    private CategoriesService categoriesService;

    public ProductsController(ProductService productService, CategoriesService categoriesService) {
        this.productService = productService;
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public List<Products> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<String> saveProduct (@RequestBody Products product) {
        if (product.getCategoryId() == null) {
            return ResponseEntity.badRequest().body("Category ID is required");
        }

        Categories category = categoriesService.findCategories(product.getCategoryId());
        if (category == null) {
            return ResponseEntity.badRequest().body("Invalid Category ID");
        }

        product.setCategory(category);
        this.productService.saveProduct(product);

        return ResponseEntity.ok("Product created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) {
        return productService.findProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct (@PathVariable Long id, @RequestBody Products product) {
        productService.editProduct(id, product);
        return ResponseEntity.ok("Product updated");
    }
}
