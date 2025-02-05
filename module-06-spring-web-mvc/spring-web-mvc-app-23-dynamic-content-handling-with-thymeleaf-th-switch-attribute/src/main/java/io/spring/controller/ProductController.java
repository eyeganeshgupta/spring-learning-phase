package io.spring.controller;

import io.spring.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> products = Arrays.asList(
            new Product(1, "Smartphone", "Flagship device with 5G", 63900.00, "Electronics"),
            new Product(2, "Laptop", "16GB RAM, 1TB SSD", 96957.00, "Electronics"),
            new Product(3, "T-Shirt", "Comfortable cotton t-shirt", 549.99, "Clothing"),
            new Product(4, "Washing Machine", "High-efficiency washer", 60445.00, "Appliances")
    );

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts(Model model) {
        model.addAttribute("products", products);
        return "product-list";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String showProductDetail(@PathVariable int id, Model model) {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("product", product);
        return "product-detail";
    }
}
