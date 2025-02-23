package com.Inti.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.Inti.backend.repository.ICategoriesRepository;
import com.Inti.backend.repository.IProductsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.Inti.backend.model.Categories;
import com.Inti.backend.model.Products;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private IProductsRepository productRepository;

    @Autowired
    private ICategoriesRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        // Lista de productos por categoría (sin asignar categoría aún)
        List<ProductData> productDataList = Arrays.asList(
                new ProductData("Eco-Friendly T-Shirt", 50L, 25.99f, "Soft and sustainable cotton t-shirt", 1L),
                new ProductData("Organic Denim Jeans", 30L, 49.99f, "Durable and stylish jeans made from organic materials", 1L),
                new ProductData("Recycled Sneakers", 40L, 69.99f, "Comfortable sneakers made from recycled plastic bottles", 1L),

                new ProductData("Vegan Facial Cleanser", 100L, 15.99f, "Gentle face wash with natural ingredients", 2L),
                new ProductData("Hydrating Face Cream", 80L, 22.50f, "Moisturizer with natural oils for soft skin", 2L),
                new ProductData("Vitamin C Serum", 60L, 30.99f, "Brightening serum with plant-based vitamin C", 2L),

                new ProductData("Lavender Essential Oil", 120L, 12.99f, "Pure lavender oil for relaxation and sleep", 3L),
                new ProductData("Peppermint Essential Oil", 100L, 10.99f, "Refreshing oil for headaches and congestion relief", 3L),
                new ProductData("Tea Tree Essential Oil", 110L, 14.50f, "Antibacterial oil great for skin care", 3L),

                new ProductData("Organic Body Lotion", 90L, 18.99f, "Moisturizing body lotion with natural ingredients", 4L),
                new ProductData("Natural Body Wash", 85L, 14.99f, "Sulfate-free and eco-friendly body wash", 4L),
                new ProductData("Exfoliating Scrub", 70L, 20.99f, "Gentle scrub with organic sugar and oils", 4L),

                new ProductData("Eco Laundry Detergent", 75L, 19.99f, "Plant-based detergent for clean and fresh clothes", 5L),
                new ProductData("Multi-Surface Cleaner", 90L, 12.50f, "All-natural cleaner for every room", 5L),
                new ProductData("Biodegradable Sponges", 110L, 9.99f, "Compostable kitchen sponges", 5L),

                new ProductData("Sulfate-Free Shampoo", 100L, 16.99f, "Nourishing shampoo for healthy hair", 6L),
                new ProductData("Organic Conditioner", 80L, 17.99f, "Hydrating conditioner with essential oils", 6L),
                new ProductData("Hair Strengthening Serum", 70L, 22.99f, "Natural serum for stronger hair", 6L),

                new ProductData("Organic Pet Shampoo", 50L, 14.99f, "Gentle shampoo for sensitive pet skin", 7L),
                new ProductData("Vegan Dog Treats", 60L, 10.50f, "Delicious and healthy treats for dogs", 7L),
                new ProductData("Eco-Friendly Cat Litter", 40L, 19.99f, "Biodegradable litter for odor control", 7L),

                new ProductData("Plant-Based Protein Powder", 90L, 34.99f, "Rich in nutrients and perfect for fitness", 8L),
                new ProductData("Vegan Chocolate Protein Bar", 120L, 3.99f, "High protein bar for energy boost", 8L),
                new ProductData("Pea Protein Powder", 75L, 29.99f, "Pure pea protein for muscle growth", 8L),

                new ProductData("Vegan Cheese Spread", 60L, 5.99f, "Delicious plant-based cheese spread", 9L),
                new ProductData("Cashew Cheese Block", 40L, 8.99f, "Artisan cashew-based cheese", 9L),
                new ProductData("Aged Vegan Parmesan", 30L, 9.99f, "Dairy-free parmesan alternative", 9L),

                new ProductData("Vegan Chocolate Cake", 50L, 19.99f, "Decadent plant-based chocolate cake", 10L),
                new ProductData("Gluten-Free Vegan Muffins", 80L, 12.99f, "Soft and tasty muffins for all diets", 10L),
                new ProductData("Coconut Flour Brownies", 70L, 14.99f, "Rich brownies made with coconut flour", 10L)
        );

        // Insertar productos asegurando que las categorías existen
        for (ProductData data : productDataList) {
            Optional<Categories> categoryOpt = categoryRepository.findById(data.categoryId);

            if (categoryOpt.isPresent()) {
                Categories category = categoryOpt.get();

                // Verificar si el producto ya existe en la categoría
                if (!productRepository.existsByNameAndCategory(data.name, category)) {
                    Products product = new Products(data.name, data.quantity, data.price, data.description, "https://res.cloudinary.com/dw57gwzru/image/upload/v1737608807/Eye-5_hn06eb.png", category);
                    productRepository.save(product);
                    System.out.println("✅ Insertado: " + product.getName() + " en categoría: " + category.getName());
                } else {
                    System.out.println("⚠️ Ya existe: " + data.name + " en categoría: " + category.getName());
                }
            } else {
                System.out.println("❌ No se encontró la categoría con ID: " + data.categoryId);
            }
        }
    }

    // Clase interna para manejar datos antes de asignar la categoría
    private static class ProductData {
        String name;
        Long quantity;
        Float price;
        String description;
        Long categoryId;

        ProductData(String name, Long quantity, Float price, String description, Long categoryId) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.description = description;
            this.categoryId = categoryId;
        }
    }
}
