package io.spring.beans;

public class Student {
    private int studentId;
    private String name;

    // Constructor
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Student(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
