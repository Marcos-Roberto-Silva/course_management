package br.com.inovacode.course_menagement.exceptions;

public class CourseFoundException extends RuntimeException {
    public CourseFoundException() {
        super("Course already registered");
    }
}
