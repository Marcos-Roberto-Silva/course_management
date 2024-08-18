package br.com.inovacode.course_menagement.exceptions;

public class NoCoursesFoundException extends RuntimeException {
    public NoCoursesFoundException(String message) {
        super(message);
    }
}