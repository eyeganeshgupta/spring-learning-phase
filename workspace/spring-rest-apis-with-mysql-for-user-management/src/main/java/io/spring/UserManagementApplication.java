package io.spring;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "User Management API",
                description = "API documentation for managing users in the system",
                version = "v1.0",
                contact = @Contact(
                        name = "Ganesh",
                        email = "eyeganeshgupta@gmail.com",
                        url = "https://about-ganesh.vercel.app/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://about-ganesh.vercel.app/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "https://about-ganesh.vercel.app/"
        )
)
public class UserManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }
}
