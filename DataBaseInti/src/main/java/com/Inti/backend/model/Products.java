package com.Inti.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_product;

    private String name;
    private Long quantity;
    private Float price;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;

    public Products(Long id_product, String name, Long quantity, Float price, String description, String image, Categories category) {
        this.id_product = id_product;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public Products() {

    }

    public Long getId_product() { return id_product; }
    public void setId_product(Long id_product) { this.id_product = id_product; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Categories getCategory() { return category; } // 🔥 Devuelve el objeto completo
    public void setCategory(Categories category) { this.category = category; } // 🔥 Se guarda la relación
}
