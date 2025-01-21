package io.spring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String greet(HttpServletRequest request) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy 'at' hh:mm a");
        String formattedDate = formatter.format(date);
        request.setAttribute("date", formattedDate);
        return "home.jsp";
    }
}
