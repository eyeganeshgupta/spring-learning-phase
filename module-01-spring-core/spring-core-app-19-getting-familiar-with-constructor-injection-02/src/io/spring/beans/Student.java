package io.spring.beans;

public class Student {
    private int studentId;

    // Constructor
    public Student(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                '}';
    }
}
