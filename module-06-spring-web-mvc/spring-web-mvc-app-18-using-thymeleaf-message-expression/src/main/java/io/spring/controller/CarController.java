package io.spring.controller;

import io.spring.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public String showCarDetails(Model model) {
        Car car = new Car("Tesla", "Model S", 7999999.99);
        model.addAttribute("car", car);
        return "car-details";
    }
}
