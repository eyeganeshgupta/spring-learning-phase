package io.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String welcome(@RequestParam(name = "number1", required = true, defaultValue = "0") Integer number1,
                          @RequestParam(name = "number2", required = true, defaultValue = "0") Integer number2,
                          Model model) {
        int sum = number1 + number2;

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("sum", sum);

        return "result.jsp";
    }
}
