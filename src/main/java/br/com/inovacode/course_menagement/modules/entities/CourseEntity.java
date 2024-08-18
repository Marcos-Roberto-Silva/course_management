package br.com.inovacode.course_menagement.modules.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.inovacode.course_menagement.CourseStatusEnum.CourseStatus;
import br.com.inovacode.course_menagement.utils.CourseStatusDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    
    @JsonDeserialize(using = CourseStatusDeserializer.class)
    private CourseStatus active;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(updatable = false)
    private LocalDateTime updated_at;
}