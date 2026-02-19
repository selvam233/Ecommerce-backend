package Springboot_ecommerce.Ecommerce_project.Specs;

import Springboot_ecommerce.Ecommerce_project.Entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class productspecs {

    public static Specification<Product> hasCategory(String category) {
        return (root, query, cb) ->
                category == null ? null :
                        cb.equal(root.get("Category"), category);
    }

    public static Specification<Product> priceBetween(Double min, Double max) {
        return (root, query, cb) -> {

            if (min == null && max == null)
                return null;

            if (min == null)
                return cb.lessThanOrEqualTo(root.get("price"), max);

            if (max == null)
                return cb.greaterThanOrEqualTo(root.get("price"), min);

            return cb.between(root.get("price"), min, max);
        };
    }

    public static Specification<Product> hasnameordesc(String keyword) {
        return (root, query, cb) -> {

            if (keyword == null || keyword.isEmpty())
                return null;

            return cb.or(
                    cb.like(cb.lower(root.get("name")),
                            "%" + keyword.toLowerCase() + "%"),
                    cb.like(cb.lower(root.get("Description")),
                            "%" + keyword.toLowerCase() + "%")
            );
        };
    }

    public static Specification<Product> ratinggreaterthan(Double ratings) {
        return (root, query, cb) -> {
            if (ratings == null)
                return null;

            return cb.greaterThanOrEqualTo(root.get("ratings"), ratings);
        };
    }
}
