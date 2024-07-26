package io.spring.beans;

public class Programmer {
    private String name;
    private int age;
    private String language;
    private Computer computer;

    // Constructor
    public Programmer() {
        System.out.println("Programmer Bean Created");
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    // Method to display programmer details
    public void displayDetails() {
        System.out.println("******************************");
        System.out.println("*       Programmer Details    *");
        System.out.println("******************************");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Language   : " + language);
        System.out.println("******************************");
        System.out.println("*        Computer Details     *");
        System.out.println("******************************");
        System.out.println("Brand      : " + computer.getBrand());
        System.out.println("Processor  : " + computer.getProcessor());
        System.out.println("RAM Size   : " + computer.getRamSize() + " GB");
        System.out.println("Storage    : " + computer.getStorageSize() + " GB");
        System.out.println("******************************\n");
    }
}
