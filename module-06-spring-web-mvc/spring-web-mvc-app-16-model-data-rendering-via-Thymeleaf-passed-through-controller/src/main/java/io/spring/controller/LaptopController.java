package io.spring.controller;

import io.spring.model.Laptop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LaptopController {
    @RequestMapping(value = "/laptop", method = RequestMethod.GET)
    public String showLaptopDetails(Model model) {
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("XPS 13");
        laptop.setPrice(196689);

        // Adding the Laptop object to the model
        model.addAttribute("laptop", laptop);

        return "laptop-details";
    }
}
