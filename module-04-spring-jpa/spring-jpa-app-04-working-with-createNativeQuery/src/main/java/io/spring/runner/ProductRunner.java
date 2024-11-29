package io.spring.runner;

import io.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRunner implements CommandLineRunner {

    private final ProductService productService;

    @Autowired
    public ProductRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        List<Object[]> products = productService.getAllProducts();

        String header = String.format(
                "%-12s %-21s %-44s %-10s %-10s %-12s",
                "Product ID", "Product Name", "Description", "Price", "Quantity", "Category ID"
        );

        System.out.println(header);
        System.out.println("=".repeat(header.length()));

        products.forEach(row -> System.out.println(String.format(
                "%-12s %-21s %-44s %-10.2f %-10d %-12d",
                row[0], row[1], row[2], (double) row[3], (int) row[4], (int) row[5]
        )));
    }
}
