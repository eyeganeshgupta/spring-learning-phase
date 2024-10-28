package io.spring.runner;

import io.spring.entity.Product;
import io.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductRunner implements CommandLineRunner {
    private final ProductService productService;

    @Autowired
    public ProductRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose an action: 'add', 'fetch', 'update', 'delete', or 'exit' to quit:");
                String caseType = scanner.nextLine().trim().toLowerCase();

                if ("exit".equals(caseType)) {
                    System.out.println("Exiting the program.");
                    break;
                }

                switch (caseType) {
                    case "add":
                        System.out.println("Enter product name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter product description:");
                        String description = scanner.nextLine();
                        System.out.println("Enter product price:");
                        double price = scanner.nextDouble();
                        System.out.println("Enter product quantity:");
                        int quantity = scanner.nextInt();
                        System.out.println("Enter category ID:");
                        int categoryId = scanner.nextInt();
                        scanner.nextLine();

                        Product newProduct = new Product(name, description, price, quantity, categoryId);
                        productService.save(newProduct);
                        System.out.println("-> Saved new product: " + newProduct);
                        break;

                    case "fetch":
                        System.out.println("Enter product ID to fetch:");
                        int fetchId = scanner.nextInt();
                        scanner.nextLine();
                        Product fetchedProduct = productService.getProductById(fetchId);
                        System.out.println("-> Product with ID " + fetchId + ": " + fetchedProduct);
                        break;

                    case "update":
                        System.out.println("Enter product ID to update:");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        Product existingProduct = productService.getProductById(updateId);
                        if (existingProduct != null) {
                            System.out.println("Enter new price for the product:");
                            double newPrice = scanner.nextDouble();
                            existingProduct.setPrice(newPrice);
                            Product updatedProduct = productService.updateProduct(existingProduct);
                            System.out.println("-> Updated product: " + updatedProduct);
                        } else {
                            System.out.println("-> No product found with ID " + updateId);
                        }
                        break;

                    case "delete":
                        System.out.println("Enter product ID to delete:");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        productService.deleteProductById(deleteId);
                        System.out.println("-> Deleted product with ID " + deleteId);
                        break;

                    default:
                        System.out.println("Invalid action. Please choose 'add', 'fetch', 'update', 'delete', or 'exit'.");
                        break;
                }
            }
        }
    }
}
