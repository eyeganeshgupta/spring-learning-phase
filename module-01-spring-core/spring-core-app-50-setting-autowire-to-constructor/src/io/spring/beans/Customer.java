package io.spring.beans;

public class Customer {
    // Properties
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private Account account;

    // Constructor
    public Customer() {
        System.out.println("Customer bean created!");
    }

    public Customer(Account account) {
        System.out.println("Single Parameter Constructor Called.");
        this.account = account;
    }

    public Customer(String customerId, String name, String email, String phoneNumber, Account account) {
        System.out.println("5 Parameter Constructor Called");
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // Method to display customer details in a decorative manner
    public void displayDetails() {
        String border = "==========================================";
        String header = String.format("%-20s : %s", "Customer Details", "");
        String line1 = String.format("%-20s : %s", "Customer ID", customerId);
        String line2 = String.format("%-20s : %s", "Name", name);
        String line3 = String.format("%-20s : %s", "Email", email);
        String line4 = String.format("%-20s : %s", "Phone Number", phoneNumber);
        String accountHeader = String.format("%-20s : ", "Account Details");

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(accountHeader);
        System.out.println(account.toString().replace("=", ":").replace("{", "").replace("}", "").replace(",", "\n"));
        System.out.println(border);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                '}';
    }
}
