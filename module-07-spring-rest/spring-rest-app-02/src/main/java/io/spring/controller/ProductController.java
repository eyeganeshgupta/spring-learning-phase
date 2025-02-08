package io.spring.controller;

import io.spring.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/product")
    public Product getProduct() {
        Product product = new Product("Laptop", "Powerful laptop for work and gaming", 1200.00);
        return product;
    }

}