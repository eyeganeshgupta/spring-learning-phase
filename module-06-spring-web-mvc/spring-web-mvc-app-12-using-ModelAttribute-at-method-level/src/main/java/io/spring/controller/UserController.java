package io.spring.controller;

import io.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    /*
           🌟 Using @ModelAttribute at Method Level 🌟
                👉 We can use @ModelAttribute at the method level in Spring Web MVC.
                👉 This method is then called before any controller method that handles a request.
                👉 The returned value from this method is automatically added to the Model and can be accessed in multiple views.
     */

    // Middleware to add dynamic date and time to the model
    @ModelAttribute("currentDate")
    public String addCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy, HH:mm:ss");
        return dateFormat.format(new Date());
    }

    // Method to display the form
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model) {
        return "home.jsp";
    }

    // Method to handle form submission and display user details
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user); // Adding submitted user data to the model
        return "display.jsp";
    }
}
