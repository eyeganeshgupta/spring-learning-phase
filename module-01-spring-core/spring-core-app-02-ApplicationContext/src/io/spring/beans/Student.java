package io.spring.beans;

public class Student {
    private int rollNo;
    private String name;

    // Default constructor that prints a message when a Student bean is created
    public Student() {
        System.out.println("Student Bean Created");
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
