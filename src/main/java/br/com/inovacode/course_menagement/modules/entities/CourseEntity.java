package br.com.inovacode.course_menagement.modules.entities;
import java.time.LocalDateTime;

public class CourseEntity {
    private String id;
    private String name;
    private String category;
    private Boolean active;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}