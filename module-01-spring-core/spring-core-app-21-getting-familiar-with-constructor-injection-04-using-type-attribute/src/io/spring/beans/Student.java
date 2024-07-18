package io.spring.beans;

public class Student {
    private int studentId;
    private String name;

    // Constructor
    public Student(int studentId) {
        this.studentId = studentId;
        System.out.println("int constructor");
    }

    public Student(String name) {
        this.name = name;
        System.out.println("String constructor");
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
