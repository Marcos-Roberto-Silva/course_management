package br.com.inovacode.course_menagement.modules.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "name is a mandatory field")
    private String name;

    @NotBlank(message = "category is a mandatory field")
    private String category;

    private Boolean active;

    @CreationTimestamp
    private LocalDateTime created_at;

    @CreationTimestamp
    private LocalDateTime updated_at;
}