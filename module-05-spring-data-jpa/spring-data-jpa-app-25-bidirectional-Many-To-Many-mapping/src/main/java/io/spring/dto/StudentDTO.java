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
    private List<CourseDTO> enrolledCourses;

    public StudentDTO() {

    }

    public StudentDTO(Long id, String firstName, String lastName, String email, String phoneNumber,
                      LocalDate dateOfBirth, LocalDate enrollmentDate, Boolean isActive, List<CourseDTO> enrolledCourses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
        this.isActive = isActive;
        this.enrolledCourses = enrolledCourses;
    }

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

    public List<CourseDTO> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<CourseDTO> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n🎓 **Student Details** 🎓")
                .append("\n═════════════════════════")
                .append("\n🆔 ID: ").append(id)
                .append("\n👤 Name: ").append(firstName).append(" ").append(lastName)
                .append("\n📧 Email: ").append(email)
                .append("\n📞 Phone: ").append(phoneNumber != null ? phoneNumber : "N/A")
                .append("\n🎂 Date of Birth: ").append(dateOfBirth != null ? dateOfBirth : "N/A")
                .append("\n📅 Enrollment Date: ").append(enrollmentDate != null ? enrollmentDate : "N/A")
                .append("\n🔵 Active Status: ").append(isActive != null && isActive ? "✅ Active" : "❌ Inactive")
                .append("\n📚 Enrolled Courses: ");

        if (enrolledCourses == null || enrolledCourses.isEmpty()) {
            sb.append("None");
        } else {
            for (CourseDTO course : enrolledCourses) {
                sb.append("\n   - ").append(course.getName())
                        .append(" (Code: ").append(course.getCourseCode()).append(")");
            }
        }

        sb.append("\n═════════════════════════\n");
        return sb.toString();
    }
}
