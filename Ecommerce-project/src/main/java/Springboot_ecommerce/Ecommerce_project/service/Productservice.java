package Springboot_ecommerce.Ecommerce_project.service;

import Springboot_ecommerce.Ecommerce_project.Entity.Product;
import Springboot_ecommerce.Ecommerce_project.Respository.ProductRepository;
import Springboot_ecommerce.Ecommerce_project.Specs.productspecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Productservice {

    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("products", products.getContent());
        response.put("totalProducts", products.getTotalElements());

        return response;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id " + id));
    }

    public List<Product> searchProducts(
            String category,
            Double minPrice,
            Double maxPrice,
            String keyword,
            Double rating
    ) {

        Specification<Product> specs = Specification
                .where(productspecs.hasCategory(category))
                .and(productspecs.priceBetween(minPrice, maxPrice))
                .and(productspecs.hasnameordesc(keyword))
                .and(productspecs.ratinggreaterthan(rating));

        return productRepository.findAll(specs);
    }
}
