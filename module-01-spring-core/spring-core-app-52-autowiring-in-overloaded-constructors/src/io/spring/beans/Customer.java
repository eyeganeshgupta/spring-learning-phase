package io.spring.beans;

public class Customer {
    // Properties
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private Account account;
    private Address address;

    // Constructor
    public Customer() {
        System.out.println("Customer bean created!");
    }

    public Customer(Account account, Address address) {
        System.out.println("2 Parameter Account-Address Constructor.");
        this.account = account;
        this.address = address;
    }

    public Customer(String customerId, String name, String email, String phoneNumber, Account account, Address address) {
        System.out.println("6 Parameter Customer Constructor.");
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Method to display customer details in a decorative manner
    public void displayDetails() {
        String border = "==========================================";
        String header = String.format("%-20s : %s", "Customer Details", "");
        String line1 = String.format("%-20s : %s", "Customer ID", customerId);
        String line2 = String.format("%-20s : %s", "Name", name);
        String line3 = String.format("%-20s : %s", "Email", email);
        String line4 = String.format("%-20s : %s", "Phone Number", phoneNumber);
        String accountHeader = String.format("%-20s : ", "\nAccount Details");
        String addressHeader = String.format("%-20s : ", "\nAddress");

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(accountHeader);
        System.out.println(account.toString().replace("=", ":").replace("{", "").replace("}", "").replace(",", "\n"));
        System.out.println(addressHeader);
        System.out.println(address.formatAddress().replace(", ", "\n"));
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
                ", address=" + address +
                '}';
    }
}
