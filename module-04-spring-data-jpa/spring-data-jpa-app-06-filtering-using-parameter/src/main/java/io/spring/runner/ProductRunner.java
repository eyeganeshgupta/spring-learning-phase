package io.spring.runner;

import io.spring.entity.Product;
import io.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner implements CommandLineRunner {

    private final ProductService productService;

    @Autowired
    public ProductRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        Product product = productService.getProductByName("Perfume");
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }
}
