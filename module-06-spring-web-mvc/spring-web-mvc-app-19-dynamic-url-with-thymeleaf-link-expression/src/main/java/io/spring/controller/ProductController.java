package io.spring.controller;

import io.spring.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> products = Arrays.asList(
            new Product(1, "Smartphone", "A high-end smartphone with advanced features", 999.99, "/images/smartphone.jpg"),
            new Product(2, "Laptop", "A powerful laptop for professionals", 1299.99, "/images/laptop.jpg"),
            new Product(3, "Headphones", "Noise-cancelling headphones for audiophiles", 199.99, "/images/headphones.jpg")
    );

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable int id, Model model) {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("product", product);
        return "product-detail";
    }
}
