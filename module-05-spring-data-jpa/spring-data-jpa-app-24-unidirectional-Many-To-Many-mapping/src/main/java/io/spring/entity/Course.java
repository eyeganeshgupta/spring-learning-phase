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

    // Inverse side of Many-to-Many relationship (optional)
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

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

    @Override
    public String toString() {
        return "\n📘 **Course Details** 📘" +
                "\n═════════════════════════" +
                "\n🆔 ID: " + id +
                "\n📖 Name: " + name +
                "\n🔢 Code: " + courseCode +
                "\n📅 Start Date: " + (startDate != null ? startDate : "N/A") +
                "\n🔵 Active Status: " + (isActive != null && isActive ? "✅ Active" : "❌ Inactive") +
                "\n👥 Enrolled Students: " + students.size() +
                "\n═════════════════════════\n";
    }
}
