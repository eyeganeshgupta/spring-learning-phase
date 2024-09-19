package io.spring.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public class EmailService {
    private String smtpHost;
    private int smtpPort;
    private String username;
    private String password;

    // Constructor
    public EmailService(@Value("smtp.example.com") String smtpHost, @Value("587") int smtpPort, @Value("eyeganeshgupta@gmail.com") String username, @Value("willpeacewin") String password) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.username = username;
        this.password = password;
        System.out.println("==== EmailService bean created! ====");
    }

    // Method to send an email
    public void sendEmail(String to, String subject, String body) {
        // Set properties for the mail session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Authenticate the session with the provided username and password
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // From email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Recipient email address
            message.setSubject(subject); // Subject of the email
            message.setText(body); // Body of the email

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully to " + to);

        } catch (MessagingException e) {
            System.err.println("Error while sending email: " + e.getMessage());
        }
    }

    // Method to send a welcome email
    public void sendWelcomeEmail(String to) {
        String subject = "Welcome to Our Service";
        String body = "Dear User,\n\nThank you for joining our service. We're excited to have you on board!\n\nBest Regards,\nSupport Team";
        sendEmail(to, subject, body);
    }

    // Method to send password reset email
    public void sendPasswordResetEmail(String to, String resetLink) {
        String subject = "Password Reset Request";
        String body = "Dear User,\n\nWe received a request to reset your password. Please use the following link to reset it:\n" + resetLink + "\n\nBest Regards,\nSupport Team";
        sendEmail(to, subject, body);
    }
}