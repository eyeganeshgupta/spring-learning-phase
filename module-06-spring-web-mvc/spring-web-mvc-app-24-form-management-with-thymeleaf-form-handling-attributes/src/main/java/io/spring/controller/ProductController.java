package io.spring.controller;

import io.spring.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @RequestMapping(value = "/product-form", method = RequestMethod.GET)
    public String showProductForm(Model model) {
        // Adding an empty product object to the model for the form
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @RequestMapping(value = "/submit-product", method = RequestMethod.POST)
    public String submitProduct(@ModelAttribute Product product, Model model) {
        // Adding the submitted product to the model for confirmation
        model.addAttribute("submittedProduct", product);
        return "product-confirmation";
    }
}
