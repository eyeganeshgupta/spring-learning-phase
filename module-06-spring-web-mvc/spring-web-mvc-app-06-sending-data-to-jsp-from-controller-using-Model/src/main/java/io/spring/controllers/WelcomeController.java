package io.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String greet(Model model) {
        model.addAttribute("message", "Hello! Welcome to Our Web App");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy 'at' hh:mm a");
        String formattedDate = formatter.format(date);
        model.addAttribute("date", formattedDate);

        return "home.jsp";
    }
}
