package br.com.inovacode.course_menagement.modules.controller;

import br.com.inovacode.course_menagement.exceptions.CourseNotFoundException;
import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.useCases.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("course")
public class DeleteCourse {
    @Autowired
    private CourseUseCase courseUseCase;

    @DeleteMapping("/{id}/")
    public ResponseEntity<Object> update(
            @PathVariable UUID id) {
        try {
            this.courseUseCase.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
