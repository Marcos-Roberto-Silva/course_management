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
@RequestMapping("update/course")
public class UpdateCourse {
    @Autowired
    private CourseUseCase courseUseCase;

    @PutMapping("/{id}/")
    public ResponseEntity<Object> update(
            @PathVariable UUID id,
            @Valid @RequestBody CourseEntity courseEntity) {
        try {
            var result = this.courseUseCase.updateCourse(id, courseEntity);
            return ResponseEntity.ok().body(result);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
