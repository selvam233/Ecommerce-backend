package Springboot_ecommerce.Ecommerce_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Product_review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value=1)
    @Max(value=10)
    private Integer rating;
    private String comment;
    public Product_review() {}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Min(value = 1) @Max(value = 10) Integer getRating() {
        return rating;
    }

    public void setRating(@Min(value = 1) @Max(value = 10) Integer rating) {
        this.rating = rating;
    }

    public Product_review(String comment, Long id, Integer rating) {
        this.comment = comment;
        this.id = id;
        this.rating = rating;
    }
}
