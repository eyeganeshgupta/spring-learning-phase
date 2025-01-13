package io.spring.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate enrollmentDate;
    private Boolean isActive;
    private List<CourseDTO> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "\n🎓 **Student Details (DTO)** 🎓" +
                "\n═══════════════════════════════" +
                "\n🆔 ID: " + id +
                "\n👤 Name: " + firstName + " " + lastName +
                "\n📧 Email: " + email +
                "\n📞 Phone: " + (phoneNumber != null ? phoneNumber : "N/A") +
                "\n🎂 Date of Birth: " + (dateOfBirth != null ? dateOfBirth : "N/A") +
                "\n📅 Enrollment Date: " + (enrollmentDate != null ? enrollmentDate : "N/A") +
                "\n🔵 Active Status: " + (isActive != null && isActive ? "✅ Active" : "❌ Inactive") +
                "\n📚 Courses Enrolled:" + formatCourses() +
                "\n═══════════════════════════════\n";
    }

    private String formatCourses() {
        if (courses == null || courses.isEmpty()) {
            return " None";
        }
        StringBuilder formattedCourses = new StringBuilder();
        for (CourseDTO course : courses) {
            formattedCourses.append("\n   📘 ").append(course.getName())
                    .append(" (Code: ").append(course.getCourseCode()).append(")");
        }
        return formattedCourses.toString();
    }
}
