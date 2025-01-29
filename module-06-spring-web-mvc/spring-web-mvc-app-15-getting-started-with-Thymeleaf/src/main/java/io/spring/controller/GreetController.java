package io.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetController {
    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greet(Model model) {
        model.addAttribute("message", "Welcome to Our Site!");
        return "greeting";
    }
}
