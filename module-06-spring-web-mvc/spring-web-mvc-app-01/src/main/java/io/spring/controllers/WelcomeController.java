package io.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public String greet() {
        return """
               <!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>Welcome</title>
                   <style>
                       body {
                           background: linear-gradient(to right, #ff7e5f, #feb47b);
                           font-family: 'Arial', sans-serif;
                           margin: 0;
                           padding: 0;
                           display: flex;
                           justify-content: center;
                           align-items: center;
                           height: 100vh;
                           color: white;
                       }
                       .welcome-container {
                           text-align: center;
                           padding: 20px;
                           border-radius: 15px;
                           background-color: rgba(0, 0, 0, 0.5);
                           box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
                       }
                       h1 {
                           font-size: 3rem;
                           text-shadow: 2px 2px #000000;
                           margin-bottom: 20px;
                       }
                   </style>
               </head>
               <body>
                   <div class="welcome-container">
                       <h1>Welcome to Spring Web MVC</h1>
                   </div>
               </body>
               </html>
               """;
    }
}
