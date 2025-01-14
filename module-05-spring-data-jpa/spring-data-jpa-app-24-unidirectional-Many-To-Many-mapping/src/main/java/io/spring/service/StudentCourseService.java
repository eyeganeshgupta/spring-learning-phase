package io.spring.service;

import io.spring.dto.CourseDTO;
import io.spring.dto.StudentDTO;
import io.spring.entity.Course;
import io.spring.entity.Student;
import io.spring.repository.CourseRepository;
import io.spring.repository.StudentRepository;
import io.spring.mapper.StudentMapper;
import io.spring.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Add a new course
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course courseEntity = CourseMapper.toCourseEntity(courseDTO);
        Course savedCourse = courseRepository.save(courseEntity);
        return CourseMapper.toCourseDTO(savedCourse);
    }

    // Add a new student
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student studentEntity = StudentMapper.toStudentEntity(studentDTO);
        Student savedStudent = studentRepository.save(studentEntity);
        return StudentMapper.toStudentDTO(savedStudent);
    }

    // Enroll a student in a course
    public String enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null) {
            return "Student or Course not found!";
        }

        student.addCourse(course); // Add course to student's list
        studentRepository.save(student); // Saving updated student
        return "Student enrolled in the course successfully!";
    }

    // Retrieve all students along with their courses
    public List<StudentDTO> getAllStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    // Delete a student by ID
    public String deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            return "Student not found!";
        } else {
            /*
             * 📝 Explanation:
             * In a Many-to-Many bidirectional relationship:
             * - The `Student` entity is the **owning side**.
             * - The `Course` entity is the **inverse side**.
             *
             * ⚠️ When deleting a `Student`:
             * - It is important to break the association between the `Student` and its associated `Courses`.
             * - This ensures that the join table (`student_course`) is properly updated,
             *   and no orphaned relationships remain.
             *
             * ✅ Steps to delete a student:
             * 1. Clear the `courses` collection in the `Student` entity (`student.getCourses().clear()`).
             *    - This breaks the association between the student and its courses.
             * 2. Delete the `Student` entity itself using `studentRepository.delete(student)`.
             *
             * This approach ensures:
             * - Referential integrity between `Student` and `Course`.
             * - No orphaned records in the join table (`student_course`).
             */
            student.getCourses().clear(); // Break associations with all courses
            studentRepository.delete(student); // Delete the student from the database
            return "Student deleted successfully!";
        }
    }

    // Delete a course by ID
    public String deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return "Course not found!";
        } else {
            /*
             * 📝 Explanation:
             * In a Many-to-Many bidirectional relationship:
             * - The `Student` entity is the **owning side**.
             * - The `Course` entity is the **inverse side**.
             *
             * ⚠️ Since the `Course` entity does not manage the join table (`student_course`),
             * it does not have direct knowledge of its entries.
             *
             * ✅ To ensure proper deletion:
             * 1. We explicitly delete all entries related to this course from the join table
             *    using a native SQL query (`deleteCourseStudents`).
             * 2. After clearing the join table, we delete the course itself from the database.
             *
             * This approach ensures:
             * - Referential integrity between `Student` and `Course`.
             * - No orphaned records remain in the `student_course` join table.
             */
            courseRepository.deleteCourseStudents(courseId); // Clear related entries in the join table
            courseRepository.deleteById(courseId);           // Delete the course itself
            return "Course deleted successfully!";
        }
    }
}
