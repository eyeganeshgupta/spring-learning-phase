package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class License {
    @Value("DL-1234567890")
    private String licenseNumber;
    @Value("#{new java.util.Date(124, 8, 7)}")
    private Date issueDate;
    @Value("#{new java.util.Date(130, 0, 1)}")
    private Date expiryDate;
    @Value("Driver's License")
    private String licenseType;

    // Constructor
    public License() {
        System.out.println("==== License bean created! ====");
    }

    public License(String licenseNumber, Date issueDate, Date expiryDate, String licenseType) {
        this.licenseNumber = licenseNumber;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.licenseType = licenseType;
        System.out.println("==== License bean created! ====");
    }

    // Getters and Setters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    // Method to check if license is valid
    public boolean isValid() {
        Date today = new Date();
        return (expiryDate != null && expiryDate.after(today));
    }

    // Method to display license details
    public void displayLicenseDetails() {
        String border = "------------------------------------------";
        String header = "              License Details             ";

        // Define the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        // Format the issue and expiry dates
        String formattedIssueDate = dateFormat.format(issueDate);
        String formattedExpiryDate = dateFormat.format(expiryDate);

        String line1 = String.format("%-20s : %s", "License Number", licenseNumber);
        String line2 = String.format("%-20s : %s", "Issue Date", formattedIssueDate);
        String line3 = String.format("%-20s : %s", "Expiry Date", formattedExpiryDate);
        String line4 = String.format("%-20s : %s", "License Type", licenseType);

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(border);
    }
}
