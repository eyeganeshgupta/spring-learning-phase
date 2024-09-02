package io.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class GenerateRandomNumber {
    // Method to generate a random number and return it as a String
    public String generateRandomNumber(int length) {
        StringBuilder randomNumber = new StringBuilder();

        // Generating the random number with the specified length
        for (int i = 0; i < length; i++) {
            int digit = (int)(Math.random() * 10); // Generates a random number between 0 and 9
            randomNumber.append(digit);
        }

        return randomNumber.toString();
    }
}
