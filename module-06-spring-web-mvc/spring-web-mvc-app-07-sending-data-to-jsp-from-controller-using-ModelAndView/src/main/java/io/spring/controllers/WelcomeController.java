package io.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView greet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello! Welcome to Our Web App");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy 'at' hh:mm a");
        String formattedDate = formatter.format(date);
        modelAndView.addObject("date", formattedDate);

        modelAndView.setViewName("home.jsp");

        return modelAndView;
    }
}
