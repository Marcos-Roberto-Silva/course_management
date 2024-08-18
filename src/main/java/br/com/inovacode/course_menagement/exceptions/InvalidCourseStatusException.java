package br.com.inovacode.course_menagement.exceptions;

import lombok.Data;

@Data
public class InvalidCourseStatusException extends RuntimeException {
    private String field;

    public InvalidCourseStatusException(String message, String field) {
        super(message);
        this.field = field;
    }
}