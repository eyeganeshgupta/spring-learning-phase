package io.spring.beans;

import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String grade;
    private List<String> subjects;
    private List<Integer> marks;

    // Constructor
    public Student() {
        System.out.println("Student Constructor!");
    }

    // Getter and Setter for studentId
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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

    // Getter and Setter for subjects
    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
        System.out.println("Setting the subjects data member and it's type is: " + subjects.getClass());
    }

    // Getter and Setter for marks
    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
        System.out.println("Setting the marks data member and it's type is: " + marks.getClass());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", subjects=" + subjects +
                ", marks=" + marks +
                '}';
    }
}
