package Springboot_ecommerce.Ecommerce_project.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name should be given")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Price field should be given")
    @PositiveOrZero(message = "Price must be zero or greater")
    private Double price;

    @Column(nullable = false)
    @NotBlank(message = "Description should be given")
    private String description;

    private Double ratings = 0.0;

    @NotBlank(message = "Seller should be given")
    private String seller;

    private Integer stock;
    private String Category;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<Product_image> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_review")
    private List<Product_review> reviews;

    public Product() {
    }

    public Product(Long id,String name, Double price, String description,
                   Double ratings, String seller,
                   Integer stock,String Category) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.Category = Category;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Double getRatings() {
        return ratings;
    }

    public String getSeller() {
        return seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
}
