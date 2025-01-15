package io.spring.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false, length = 100)
    private String name;

    @Column(name = "course_code", nullable = false, unique = true, length = 10)
    private String courseCode;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> students = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    public String displayEnrolledStudents() {
        if (students.isEmpty()) {
            return "\n👥 No students are enrolled in this course.";
        }

        StringBuilder studentDetails = new StringBuilder("\n👥 Enrolled Students:");
        for (Student student : students) {
            studentDetails.append("\n   - ID: ").append(student.getId())
                    .append(", Name: ").append(student.getFirstName()).append(" ").append(student.getLastName())
                    .append(", Email: ").append(student.getEmail());
        }

        return studentDetails.toString();
    }

    @Override
    public String toString() {
        return "\n📘 **Course Details** 📘" +
                "\n═════════════════════════" +
                "\n🆔 ID: " + id +
                "\n📖 Name: " + name +
                "\n🔢 Code: " + courseCode +
                "\n📅 Start Date: " + (startDate != null ? startDate : "N/A") +
                "\n🔵 Active Status: " + (isActive != null && isActive ? "✅ Active" : "❌ Inactive") +
                displayEnrolledStudents() +
                "\n═════════════════════════\n";
    }
}
