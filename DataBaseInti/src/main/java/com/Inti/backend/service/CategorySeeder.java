package com.Inti.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.Inti.backend.repository.ICategoriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.Inti.backend.model.Categories;
import java.util.Arrays;
import java.util.List;

/*
* Se crea esta clase para insertar las categorias automaticamente cuando se arranca el proyecto
* la clase verifica si ya existe cada categoria antes de insertarla y si ya existe la omite de esta
* manera se evita insertar duplicados
*/
@Component
public class CategorySeeder implements CommandLineRunner {

    /* Se inyecta el repositorio de categorias*/
    @Autowired
    private ICategoriesRepository categoryRepository;

    /*Se implementa el metodo run como lo exije la interfaz implementada CommandLineRunner*/
    @Override
    public void run(String... args) throws Exception {

        /* Se crear una List de Categories agregando un objeto de tipo Categories por cada una de las categorias*/
        List<Categories> categories = Arrays.asList(
                new Categories("SUSTAINABLE FASHION", "Wear your values with timeless, sustainable fashion",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739998833/clothes1_wpcocu.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740000754/clothes4_kvnhoo.jpg"),

                new Categories("FACIAL CARE", "Reveal the natural glow of your skin.",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739995250/Face1_l3et94.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739996511/Face4_rsubkb.jpg"),

                new Categories("ESSENTIAL OIL", "Embrace nature’s purity with the power of essential oils",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845257/vp2_hqpst0.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845256/vp7_qjhwvc.jpg"),

                new Categories("BODY CARE", "Indulge in the natural harmony of body care essentials",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739996510/Body1_mhk5y3.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739996510/Body2_omqpgm.jpg"),

                new Categories("HOME CLEANING", "Refresh your space naturally with eco-friendly cleaning solutions.",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739939404/product-5_dgspcm.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739939403/product-6_d8sdxf.jpg"),

                new Categories("HAIR CARE", "Find the perfect touch for your hair",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739995253/Hair2_rombcs.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739941739/Hair1_ba4nxb.jpg"),

                new Categories("PETS", "Pamper your pets with accessories that care for them and the planet",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740002642/pets_hkrrmd.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740003172/pets5_xjxvpj.jpg"),

                new Categories("VEGAN PROTEINS", "Nourish yourself naturally with sustainable plant-based proteins",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740004599/milk_mkcwtc.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740004599/pets6_uadhjg.jpg"),

                new Categories("VEGAN CHEESE", "Savor the creamy goodness of plant-based vegan cheese",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845255/vp12_lw10xk.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845256/vp10_asevuj.jpg"),

                new Categories("VEGAN BAKERY", "Delight in the sweetness of cruelty-free vegan baking",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1740004956/cooks_e5ffqb.jpg",
                        "https://res.cloudinary.com/di1xiwdsn/image/upload/v1739845256/vp8_kiqxig.jpg")
        );

        /*
         * Se recorre la lista y por cada elemento se busca por el nombre usando el metodo findByName del repository de categories
         * Si la categoria no existe en la base de datos se inserta usando el metodo save del repository de categories, si ya existe
         * se omite y se muestra in mensaje indicando esto
         */
        for (Categories category : categories) {
            if (categoryRepository.findByName(category.getName()).isEmpty()) {
                categoryRepository.save(category);
                System.out.println("Insertada: " + category.getName());
            } else {
                System.out.println("Ya existe: " + category.getName());
            }
        }
    }
}
