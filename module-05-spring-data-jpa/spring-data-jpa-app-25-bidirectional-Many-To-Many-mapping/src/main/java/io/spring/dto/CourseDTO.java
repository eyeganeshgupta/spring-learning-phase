package io.spring.dto;

import java.time.LocalDate;
import java.util.List;

public class CourseDTO {
    private Long id;
    private String name;
    private String courseCode;
    private LocalDate startDate;
    private Boolean isActive;
    private List<StudentDTO> enrolledStudents;

    public CourseDTO() {

    }

    public CourseDTO(Long id, String name, String courseCode, LocalDate startDate, Boolean isActive, List<StudentDTO> enrolledStudents) {
        this.id = id;
        this.name = name;
        this.courseCode = courseCode;
        this.startDate = startDate;
        this.isActive = isActive;
        this.enrolledStudents = enrolledStudents;
    }

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

    public List<StudentDTO> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<StudentDTO> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n📘 **Course Details** 📘")
                .append("\n═════════════════════════")
                .append("\n🆔 ID: ").append(id)
                .append("\n📖 Name: ").append(name)
                .append("\n🔢 Code: ").append(courseCode)
                .append("\n📅 Start Date: ").append(startDate != null ? startDate : "N/A")
                .append("\n🔵 Active Status: ").append(isActive != null && isActive ? "✅ Active" : "❌ Inactive")
                .append("\n👥 Enrolled Students: ");

        if (enrolledStudents == null || enrolledStudents.isEmpty()) {
            sb.append("None");
        } else {
            for (StudentDTO student : enrolledStudents) {
                sb.append("\n   - ").append(student.getFirstName()).append(" ").append(student.getLastName())
                        .append(" (Email: ").append(student.getEmail()).append(")");
            }
        }

        sb.append("\n═════════════════════════\n");
        return sb.toString();
    }
}
