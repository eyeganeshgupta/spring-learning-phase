package io.spring.controller;

import io.spring.model.Laptop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/laptops")
public class LaptopController {
    private static final Map<String, Laptop> laptopData = new HashMap<>();

    static {
        laptopData.put("1", new Laptop("1", "HP Pavilion 14", "Intel Core i5", "8GB", "512GB SSD", "Integrated"));
        laptopData.put("2", new Laptop("2", "OMEN Gaming 16", "Intel Core i7", "16GB", "1TB SSD", "NVIDIA RTX 3060"));
        laptopData.put("3", new Laptop("3", "Dell Inspiron 15", "Intel Core i3", "8GB", "256GB SSD", "Integrated"));
        laptopData.put("4", new Laptop("4", "Lenovo ThinkPad X1", "Intel Core i9", "32GB", "1TB SSD", "NVIDIA RTX 3080"));
        laptopData.put("5", new Laptop("5", "ASUS ROG Zephyrus G15", "AMD Ryzen 9", "16GB", "1TB SSD", "NVIDIA RTX 3070"));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllLaptops(Model model) {
        model.addAttribute("laptops", laptopData.values());
        return "laptop-list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getLaptopById(@PathVariable("id") String id, Model model) {
        Laptop laptop = laptopData.get(id);
        model.addAttribute("laptop", laptop);
        return "laptop-detail";
    }
}
