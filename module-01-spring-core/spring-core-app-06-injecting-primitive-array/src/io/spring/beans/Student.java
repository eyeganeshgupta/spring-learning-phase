package io.spring.beans;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String grade;
    private String[] subjects;

    // Constructor
    public Student() {
        System.out.println("Student Bean Created!");
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
    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        StringBuilder subjectsList = new StringBuilder();
        for (String subject : subjects) {
            subjectsList.append(subject).append(", ");
        }
        // Remove the last comma and space
        if (!subjectsList.isEmpty()) {
            subjectsList.setLength(subjectsList.length() - 2);
        }

        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", subjects=[" + subjectsList.toString() + "]" +
                '}';
    }
}
