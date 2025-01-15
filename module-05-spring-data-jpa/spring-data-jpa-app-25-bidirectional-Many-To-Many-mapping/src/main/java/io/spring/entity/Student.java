package io.spring.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    // Owning side of Many-to-Many relationship
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
    }

    @Override
    public String toString() {
        return "\n🎓 **Student Details** 🎓" +
                "\n═════════════════════════" +
                "\n🆔 ID: " + id +
                "\n👤 Name: " + firstName + " " + lastName +
                "\n📧 Email: " + email +
                "\n📞 Phone: " + (phoneNumber != null ? phoneNumber : "N/A") +
                "\n🎂 Date of Birth: " + (dateOfBirth != null ? dateOfBirth : "N/A") +
                "\n📅 Enrollment Date: " + (enrollmentDate != null ? enrollmentDate : "N/A") +
                "\n🔵 Active Status: " + (isActive != null && isActive ? "✅ Active" : "❌ Inactive") +
                "\n📚 Courses Enrolled:" + formatCourses() +
                "\n═════════════════════════\n";
    }

    private String formatCourses() {
        if (courses.isEmpty()) {
            return " None";
        }
        StringBuilder formattedCourses = new StringBuilder();
        for (Course course : courses) {
            formattedCourses.append("\n   📘 ").append(course.getName())
                    .append(" (Code: ").append(course.getCourseCode()).append(")");
        }
        return formattedCourses.toString();
    }
}
