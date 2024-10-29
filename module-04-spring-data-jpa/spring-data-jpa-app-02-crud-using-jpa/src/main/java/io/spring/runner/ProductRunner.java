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
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose an action: 'add', 'fetch', 'update', 'delete', or 'exit' to quit:");
                String action = scanner.nextLine().trim().toLowerCase();

                if ("exit".equals(action)) {
                    System.out.println("Exiting the program.");
                    break;
                }

                switch (action) {
                    case "add":
                        addProduct(scanner);
                        break;

                    case "fetch":
                        fetchProduct(scanner);
                        break;

                    case "update":
                        updateProduct(scanner);
                        break;

                    case "delete":
                        deleteProduct(scanner);
                        break;

                    default:
                        System.out.println("Invalid action. Please choose 'add', 'fetch', 'update', 'delete', or 'exit'.");
                        break;
                }
            }
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        System.out.println("Enter product price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter category ID:");
        int categoryId = Integer.parseInt(scanner.nextLine());

        Product newProduct = new Product(name, description, price, quantity, categoryId);
        productService.create(newProduct);
        System.out.println("-> Saved new product: " + newProduct);
    }

    private void fetchProduct(Scanner scanner) {
        System.out.println("Enter product ID to fetch:");
        int fetchId = Integer.parseInt(scanner.nextLine());
        Product fetchedProduct = productService.read(fetchId);

        if (fetchedProduct != null) {
            System.out.println("-> Product with ID " + fetchId + ": " + fetchedProduct);
        } else {
            System.out.println("-> No product found with ID " + fetchId);
        }
    }

    private void updateProduct(Scanner scanner) {
        System.out.println("Enter product ID to update:");
        int updateId = Integer.parseInt(scanner.nextLine());
        Product existingProduct = productService.read(updateId);

        if (existingProduct != null) {
            System.out.println("Enter new price for the product:");
            double newPrice = Double.parseDouble(scanner.nextLine());
            existingProduct.setPrice(newPrice);
            Product updatedProduct = productService.update(existingProduct);
            System.out.println("-> Updated product: " + updatedProduct);
        } else {
            System.out.println("-> No product found with ID " + updateId);
        }
    }

    private void deleteProduct(Scanner scanner) {
        System.out.println("Enter product ID to delete:");
        int deleteId = Integer.parseInt(scanner.nextLine());
        boolean isDeleted = productService.delete(deleteId);
        if (isDeleted) {
            System.out.println("-> Deleted product with ID " + deleteId);
        } else {
            System.out.println("-> No product found with ID " + deleteId + " to delete.");
        }
    }
}
