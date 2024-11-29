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

        // Update a specific product
        String productNameToUpdate = "Perfume";
        Product productToUpdate = productService.getProductByName(productNameToUpdate);
        if (productToUpdate != null) {
            // Modify the product details
            productToUpdate.setPrice(60.0);
            productToUpdate.setDescription("Updated description for Perfume");

            int updatedCount = productService.updateProduct(productToUpdate);
            if (updatedCount > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product update failed.");
            }
        } else {
            System.out.println("Product not found: " + productNameToUpdate);
        }

        // Fetch and display product details by name
        Map<String, Object> productDetails = productService.getProductDetailsByName(productNameToUpdate);
        if (!productDetails.isEmpty()) {
            System.out.println("Product details: " + productDetails);
        } else {
            System.out.println("No details found for product: " + productNameToUpdate);
        }

        // Fetch and display products with a price greater than a specified amount
        double priceThreshold = 50.0; // Example price threshold
        List<Product> expensiveProducts = productService.getProductsByPriceGreaterThan(priceThreshold);
        System.out.println("Products with price greater than " + priceThreshold + ":");
        if (!expensiveProducts.isEmpty()) {
            for (Product expensiveProduct : expensiveProducts) {
                System.out.println(expensiveProduct);
            }
        } else {
            System.out.println("No products found with price greater than " + priceThreshold);
        }
    }
}
