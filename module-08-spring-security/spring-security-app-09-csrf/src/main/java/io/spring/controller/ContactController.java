package io.spring.controller;

import io.spring.dto.ContactDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("contact", new ContactDTO());
        return "contact-form";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("contact") ContactDTO contact,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "contact-form";
        }

        model.addAttribute("name", contact.getName());
        model.addAttribute("email", contact.getEmail());
        model.addAttribute("phone", contact.getPhone());
        model.addAttribute("subject", contact.getSubject());
        model.addAttribute("message", contact.getMessage());

        return "result";
    }
}
