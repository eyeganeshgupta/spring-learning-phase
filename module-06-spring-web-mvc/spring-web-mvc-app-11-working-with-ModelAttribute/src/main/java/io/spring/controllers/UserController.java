package io.spring.controllers;

import io.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    // Method to return the HTML form on the home route
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "index.html";
    }

    // Method to handle form submission and pass data to JSP
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        // model.addAttribute("user", user);
        return "display.jsp";
    }

    /*
           🌟 @ModelAttribute Annotation 🌟

            👉 In Spring Web MVC, the @ModelAttribute is an annotation used to bind the form data to a named model which can then be used in the view layer.
            👉 It is mainly used for:
                1️⃣ Binding form data to a method parameter in a controller.
                2️⃣ Populating the model with data that will be used in a view.
     */
}
