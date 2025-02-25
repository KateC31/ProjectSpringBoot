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
                new ProductData("Eco-Friendly T-Shirt", 50L, 25.99f, "Soft and sustainable cotton t-shirt", 1L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371536/T-shirt_pvy29p.jpg"),
                new ProductData("Organic Denim Jeans", 30L, 49.99f, "Durable and stylish jeans made from organic materials", 1L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371509/Jean_e8hzbu.jpg"),
                new ProductData("Recycled Sneakers", 40L, 69.99f, "Comfortable sneakers made from recycled plastic bottles", 1L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371509/tennis_i2zgfq.jpg"),
                new ProductData("Recycled Bag", 40L, 69.99f, "Practical bag made from recycled plastic bottles", 1L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371509/bag_ku8k5e.jpg"),

                new ProductData("Vegan Facial Cleanser", 100L, 15.99f, "Gentle face wash with natural ingredients", 2L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371509/face_qo8vt6.jpg"),
                new ProductData("Hydrating Face Cream", 80L, 22.50f, "Moisturizer with natural oils for soft skin", 2L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739998834/Face3_ojb0je.jpg"),
                new ProductData("Vitamin C Serum", 60L, 30.99f, "Brightening serum with plant-based vitamin C", 2L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371509/serum-1_pnptpw.jpg"),
                new ProductData("Body cream", 60L, 30.99f, "Cruelty free body moisturizer", 2L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739998833/body_1_bk6lsn.jpg"),

                new ProductData("Lavender Essential Oil", 120L, 12.99f, "Pure lavender oil for relaxation and sleep", 3L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371509/lavender_oil_d0yb0e.jpg"),
                new ProductData("Peppermint Essential Oil", 100L, 10.99f, "Refreshing oil for headaches and congestion relief", 3L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371508/Peppermint_cbccn1.jpg"),
                new ProductData("Tea Tree Essential Oil", 110L, 14.50f, "Antibacterial oil great for skin care", 3L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371508/1_yv2c2z.jpg"),
                new ProductData("Almond Essential Oil", 110L, 14.50f, "Antibacterial oil great for skin care", 3L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740371508/serum_nludvt.jpg"),

                new ProductData("Organic Body Lotion", 90L, 18.99f, "Moisturizing body lotion with natural ingredients", 4L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740372284/Organic_Body_Lotion-1_qqcyho.jpg"),
                new ProductData("Natural Body Wash", 85L, 14.99f, "Sulfate-free and eco-friendly body wash", 4L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845256/vp5_ihqtdq.jpg"),
                new ProductData("Exfoliating Scrub", 70L, 20.99f, "Gentle scrub with organic sugar and oils", 4L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845257/vp1_k9ryhz.jpg"),
                new ProductData("Natural lotion", 70L, 20.99f, "Cruelty free natural lotion", 4L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739939404/product-4_cifdz6.jpg"),

                new ProductData("Eco Laundry Detergent", 75L, 19.99f, "Plant-based detergent for clean and fresh clothes", 5L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739939404/product-4_cifdz6.jpg"),
                new ProductData("Multi-Surface Cleaner", 90L, 12.50f, "All-natural cleaner for every room", 5L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739939404/product-2_c2dqlt.jpg"),
                new ProductData("Biodegradable Sponges", 110L, 9.99f, "Compostable kitchen sponges", 5L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739939404/product-1_xdzohd.jpg"),
                new ProductData("Bathroom scrub", 110L, 9.99f, "Recycled materials scrub", 5L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740374302/cepillo_pyw5ge.jpg"),

                new ProductData("Sulfate-Free Shampoo", 100L, 16.99f, "Nourishing shampoo for healthy hair", 6L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740372980/sahmpoo_wyzna2.jpg"),
                new ProductData("Organic Conditioner", 80L, 17.99f, "Hydrating conditioner with essential oils", 6L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740372980/acondicionador_ih9ixz.jpg"),
                new ProductData("Hair Strengthening Serum", 70L, 22.99f, "Natural serum for stronger hair", 6L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740372980/serum-cabello_hnsmpw.jpg"),
                new ProductData("Hair Treatment", 70L, 22.99f, "Natural hair treatment for healthy hair", 6L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373176/tratamiento_cabello_ggkmuy.jpg"),

                new ProductData("Organic Pet Shampoo", 50L, 14.99f, "Gentle shampoo for sensitive pet skin", 7L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740003172/pets5_xjxvpj.jpg"),
                new ProductData("Vegan Dog Treats", 60L, 10.50f, "Delicious and healthy treats for dogs", 7L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373495/snack_pet_phrosc.jpg"),
                new ProductData("Eco-Friendly Cat Litter", 40L, 19.99f, "Biodegradable litter for odor control", 7L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373479/trat_pet_ndfuoa.jpg"),
                new ProductData("Eco-Friendly Pet Toy", 40L, 19.99f, "Biodegradable Pet Toy", 7L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740002642/pets_hkrrmd.jpg"),

                new ProductData("Plant-Based Protein Powder", 90L, 34.99f, "Rich in nutrients and perfect for fitness", 8L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373815/Pea_Protein_Powder_22_qmesmk.jpg"),
                new ProductData("Vegan Chocolate Protein Bar", 120L, 3.99f, "High protein bar for energy boost", 8L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740374100/chocolate_protein_vulvpa.jpg"),
                new ProductData("Pea Protein Powder", 75L, 29.99f, "Pure pea protein for muscle growth", 8L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740004599/milk_mkcwtc.jpg"),
                new ProductData("Chickpea Protein Powder", 75L, 29.99f, "Pure chickpea protein for muscle growth", 8L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373815/Protein-1_kjgobf.jpg"),

                new ProductData("Vegan Cheese Spread", 60L, 5.99f, "Delicious plant-based cheese spread", 9L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373984/cheesse_spread_ztujju.jpg"),
                new ProductData("Cashew Cheese Block", 40L, 8.99f, "Artisan cashew-based cheese", 9L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373984/cheesse_block_qabgux.jpg"),
                new ProductData("Aged Vegan Parmesan", 30L, 9.99f, "Dairy-free parmesan alternative", 9L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373968/parmessano_tubx1t.jpg"),
                new ProductData("Vegan italian cream cheese", 30L, 9.99f, "Delicious italian plant-based cheese spread", 9L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373967/vegan_cheese-2_j7ivyo.jpg"),

                new ProductData("Vegan Chocolate Cake", 50L, 19.99f, "Decadent plant-based chocolate cake", 10L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373956/chocolotae_vegan_exokfh.jpg"),
                new ProductData("Gluten-Free Vegan Muffins", 80L, 12.99f, "Soft and tasty muffins for all diets", 10L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740374602/brownies_rzjwfs.jpg"),
                new ProductData("Coconut Flour Brownies", 70L, 14.99f, "Rich brownies made with coconut flour", 10L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740374602/brownies_rzjwfs.jpg"),
                new ProductData("Vegan cookies", 70L, 14.99f, "Vegan cookies", 10L, "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740373938/cookies_h67hrd.jpg")
        );

        // Insertar productos asegurando que las categorías existen
        for (ProductData data : productDataList) {
            Optional<Categories> categoryOpt = categoryRepository.findById(data.categoryId);

            if (categoryOpt.isPresent()) {
                Categories category = categoryOpt.get();
                System.out.println("🔍 Verificando producto: " + data.name + " en categoría: " + category.getName());

                if (!productRepository.existsByNameAndCategory(data.name, category)) {
                    Products product = new Products(data.name, data.quantity, data.price, data.description, data.image, category);
                    System.out.println("🚀 Intentando insertar: " + product.getName() + " con imagen: " + product.getImage());

                    try {
                        productRepository.save(product);
                        System.out.println("✅ Insertado correctamente: " + product.getName());
                    } catch (Exception e) {
                        System.out.println("❌ Error al insertar " + product.getName() + ": " + e.getMessage());
                    }

                } else {
                    System.out.println("⚠️ Ya existe: " + data.name);
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
        String image;

        ProductData(String name, Long quantity, Float price, String description, Long categoryId, String image) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.description = description;
            this.categoryId = categoryId;
            this.image = image;
        }
    }
}