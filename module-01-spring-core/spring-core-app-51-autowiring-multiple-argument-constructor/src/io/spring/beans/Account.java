package io.spring.beans;

public class Account {
    // Properties
    private String accountNumber;
    private String accountType;
    private double balance;

    // Constructor
    public Account() {
        System.out.println("Account bean created!");
    }

    public Account(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to display account details in a decorative manner
    public void displayDetails() {
        String border = "==========================================";
        String header = "            Account Details               ";
        String line1 = String.format("%-20s : %s", "Account Number", accountNumber);
        String line2 = String.format("%-20s : %s", "Account Type", accountType);
        String line3 = String.format("%-20s : %.2f", "Balance", balance);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(border);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
