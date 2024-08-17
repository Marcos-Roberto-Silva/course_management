package br.com.inovacode.course_menagement.modules.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseEntity {
    private UUID id;

    @NotBlank(message = "name is a mandatory field")
    private String name;

    @NotBlank(message = "category is a mandatory field")
    private String category;
    private Boolean active;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}