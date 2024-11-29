package io.spring.runner;

import io.spring.entity.Product;
import io.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProductRunner implements CommandLineRunner {

    private final ProductService productService;

    @Autowired
    public ProductRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        // Fetch and display all products
        List<Product> products = productService.getAllProducts();
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println(product);
        }

        // Fetch a specific product by name
        String productName = "Perfume";
        Product product = productService.getProductByName(productName);
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("Product not found: " + productName);
        }

        // Fetch and display product details by name
        Map<String, Object> productDetails = productService.getProductDetails(productName);
        if (!productDetails.isEmpty()) {
            System.out.println("Product details: " + productDetails);
        } else {
            System.out.println("No details found for product: " + productName);
        }
    }
}
