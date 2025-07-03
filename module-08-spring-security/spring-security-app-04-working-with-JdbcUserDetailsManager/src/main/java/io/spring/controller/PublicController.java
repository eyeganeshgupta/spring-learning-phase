package io.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private static final Logger logger = LoggerFactory.getLogger(PublicController.class);

    @GetMapping("/info")
    public String info() {
        logger.info("Accessed public endpoint: /api/public/info");
        return "Welcome to the Bank API. Please authenticate to use your account.";
    }

}
