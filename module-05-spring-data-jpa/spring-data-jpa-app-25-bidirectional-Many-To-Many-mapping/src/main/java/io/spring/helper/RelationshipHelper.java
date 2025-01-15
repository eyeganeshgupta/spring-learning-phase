package io.spring.helper;

import io.spring.entity.Course;
import io.spring.entity.Student;

public class RelationshipHelper {
    public static void addStudentToCourse(Course course, Student student) {
        // Add the student to the course's student set
        course.getStudents().add(student);

        // Add the course to the student's course set
        student.getCourses().add(course);
    }

    public static void removeStudentFromCourse(Course course, Student student) {
        // Remove the student from the course's student set
        course.getStudents().remove(student);

        // Remove the course from the student's course set
        student.getCourses().remove(course);
    }

    public static void addCourseToStudent(Student student, Course course) {
        // Add the course to the student's course set
        student.getCourses().add(course);

        // Add the student to the course's student set
        course.getStudents().add(student);
    }

    public static void removeCourseFromStudent(Student student, Course course) {
        // Remove the course from the student's course set
        student.getCourses().remove(course);

        // Remove the student from the course's student set
        course.getStudents().remove(student);
    }
}
