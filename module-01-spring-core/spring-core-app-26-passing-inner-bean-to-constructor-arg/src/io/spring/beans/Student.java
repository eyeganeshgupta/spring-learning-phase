package io.spring.beans;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String grade;
    private String email;
    private Address address;

    // Default Constructor
    public Student() {
        System.out.println("Default Student Constructor Called!");
    }

    // Parameterized Constructor
    public Student(int studentId, String name, int age, String grade, String email, Address address) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.address = address;
        System.out.println("Parameterized Student Constructor Called!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
