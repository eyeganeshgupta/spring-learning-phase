package io.spring.controller;

import io.spring.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Product product1 = new Product("Laptop", "Powerful laptop for work and gaming", 46991.00);
        Product product2 = new Product("Phone", "Smartphone with excellent camera", 15499.00);
        return List.of(product1, product2);
    }
}
