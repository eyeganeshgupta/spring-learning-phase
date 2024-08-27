package io.spring.beans;

public class Company {
    private String name;
    private String industry;
    private int yearEstablished;
    private String headquarters;
    private int numberOfEmployees;
    private double revenue; // in millions of dollars

    // Constructor
    public Company() {
        System.out.println("==== Company bean created! ====");
    }

    public Company(String name, String industry, int yearEstablished, String headquarters, int numberOfEmployees, double revenue) {
        this.name = name;
        this.industry = industry;
        this.yearEstablished = yearEstablished;
        this.headquarters = headquarters;
        this.numberOfEmployees = numberOfEmployees;
        this.revenue = revenue;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    // Method to display company details
    public void displayDetails() {
        String border = "==========================================";
        String header = "               Company Details            ";
        String line1 = String.format("%-20s : %s", "Name", name);
        String line2 = String.format("%-20s : %s", "Industry", industry);
        String line3 = String.format("%-20s : %d", "Year Established", yearEstablished);
        String line4 = String.format("%-20s : %s", "Headquarters", headquarters);
        String line5 = String.format("%-20s : %,d", "Number of Employees", numberOfEmployees);
        String line6 = String.format("%-20s : $%.2f million", "Revenue", revenue);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(border);
    }

    // Method to get company details as a formatted string
    public String getCompanyDetails() {
        return String.format("Name: %s, Industry: %s, Year Established: %d, Headquarters: %s, Number of Employees: %,d, Revenue: $%.2f million",
                name, industry, yearEstablished, headquarters, numberOfEmployees, revenue);
    }
}
