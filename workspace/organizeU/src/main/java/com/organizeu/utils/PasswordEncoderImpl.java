package com.organizeu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("password"));

        System.out.println("admin in encryptedForm: $2a$10$HfF/9fN6le1bCZgTZRQIMugEB3VN4Es24v2.d9/qol0LMSpuF9cX2");
        System.out.println("password in encryptedForm: $2a$10$C5DU/gR5IUivTwkVY0O3EuXIFObmdIGFcjkyqWGiX1Snie6cX5vmK");
    }
}
