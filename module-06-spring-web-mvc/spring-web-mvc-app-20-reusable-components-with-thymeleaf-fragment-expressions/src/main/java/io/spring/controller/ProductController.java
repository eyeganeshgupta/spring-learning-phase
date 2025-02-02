package io.spring.controller;

import io.spring.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Product> products = Arrays.asList(
                new Product(1, "Smartphone", "Flagship device with 5G", 799.99, "/images/phone.jpg"),
                new Product(2, "Laptop", "16GB RAM, 1TB SSD", 1299.99, "/images/laptop.jpg"),
                new Product(3, "Headphones", "Noise-cancelling", 199.99, "/images/headphones.jpg")
        );
        model.addAttribute("products", products);
        return "home";
    }
}
