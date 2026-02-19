package Springboot_ecommerce.Ecommerce_project.Seed;

import Springboot_ecommerce.Ecommerce_project.Entity.Product;
import Springboot_ecommerce.Ecommerce_project.Respository.ProductRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class productseeding implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count()==0)
        {
            List<Product> demoproducts=List.of(new Product(null,"Motorola edge 50 fusion",20000.0,"AI Enhanced camera features",9.7,"Amazon",45, "Motorola"),
                    new Product(null,"Motorola edge 60 pro",30000.0,"Newly Launched Mobile",9.5,"Flipkart",60, "Motorola"),
                    new Product(null,"Motorola edge 60",20000.0,"50px high rated camera features",9.7,"Amazon",100, "Motorola"),
                    new Product(null,"Oppo Reno15 pro",40000.0,"AI Enhanced camera features",9.6,"Amazon",85, "Oppo"),
                    new Product(null,"Realme GT 8 pro",25000.0,"AI Enhanced camera features",9.1,"Flipkart",300, "Realme"),
                    new Product(null,"Xiaomi Redmi Note 15 pro plus",30000.0,"AI enabled features ",9.6,"Amazon",45, "Xiaomi"),
                    new Product(null,"Motorola Signature",50000.0,"High perfomance",9.7,"Flipkart",90, "Motorola")
                    );
            productRepository.saveAll(demoproducts);
            System.out.println("seeded");
        }

    }
}
