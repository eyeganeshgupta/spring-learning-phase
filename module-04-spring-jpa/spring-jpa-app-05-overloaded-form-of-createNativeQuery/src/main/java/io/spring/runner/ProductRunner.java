package io.spring.runner;

import io.spring.entity.Product;
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
        List<Product> products = productService.getAllProducts();

        String header = String.format(
                "%-12s | %-21s | %-44s | %-10s | %-10s | %-12s",
                "Product ID", "Product Name", "Description", "Price", "Quantity", "Category ID"
        );

        System.out.println("+--------------+-----------------------+--------------------------------------------+------------+------------+--------------+");

        System.out.println(header);
        System.out.println("+--------------+-----------------------+--------------------------------------------+------------+------------+--------------+");

        products.forEach(row -> {
            String formattedRow = String.format(
                    "%-12s | %-21s | %-44s | %-10.2f | %-10d | %-12d",
                    row.getProductId(), row.getProductName(), row.getDescription(), (double) row.getPrice(), (int) row.getQuantity(), (int) row.getCategoryId()
            );
            System.out.println(formattedRow);
            System.out.println("+--------------+-----------------------+--------------------------------------------+------------+------------+--------------+");
        });
    }
}
