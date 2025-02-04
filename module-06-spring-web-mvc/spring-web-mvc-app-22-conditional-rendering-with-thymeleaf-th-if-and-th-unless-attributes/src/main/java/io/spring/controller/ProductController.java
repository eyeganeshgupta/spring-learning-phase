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
            new Product(1, "Smartphone", "Flagship device with 5G", 799.99, true),
            new Product(2, "Laptop", "16GB RAM, 1TB SSD", 1299.99, false),
            new Product(3, "Headphones", "Noise-cancelling headphones", 199.99, true)
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
