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
    public void run(String... args) throws Exception {
        Product newProduct = new Product("Nokia Lumia", "High-end smartphone with advanced features", 799.99, 50, 1);
        productService.save(newProduct);
        System.out.println("Saved new product: " + newProduct);

        Product fetchedProduct = productService.getProductById(1);
        System.out.println("Product with ID 1: " + fetchedProduct);
    }
}
