package Springboot_ecommerce.Ecommerce_project.controller;


import Springboot_ecommerce.Ecommerce_project.Entity.Product;
import Springboot_ecommerce.Ecommerce_project.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")

public class productcontroller {
    @Autowired
    private Productservice productservice;
    @GetMapping
    public Map<String,Object> getallproducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){

        return productservice.getAllProducts(page,size);
    }
  @GetMapping("/{id}")
  public Product getproductbyid(@PathVariable Long id){
     return productservice.getProductById(id);

  }
  @GetMapping("/search")
  public List<Product> searchproducts(@RequestParam(required=false) String Category,@RequestParam(required=false) Double minprice,@RequestParam(required=false) Double maxprice,@RequestParam(required=false) String Keyword,@RequestParam(required=false) Double ratings){
      return productservice.searchProducts(Category,minprice,maxprice,Keyword,ratings);
  }
}
