package io.spring.beans;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String grade;
    private String email;

    // Default Constructor
    public Student() {
        System.out.println("Default Student Constructor Called!");
    }

    // Parameterized Constructor
    public Student(int studentId, String name, int age, String grade, String email) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
        System.out.println("Parameterized Student Constructor Called!");
    }

    // Getter and Setter for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
