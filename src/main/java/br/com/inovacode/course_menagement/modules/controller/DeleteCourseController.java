package br.com.inovacode.course_menagement.modules.controller;

import br.com.inovacode.course_menagement.exceptions.CourseNotFoundException;
import br.com.inovacode.course_menagement.useCases.CourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("course")
public class DeleteCourseController {
    @Autowired
    private CourseUseCase courseUseCase;

    @DeleteMapping("/{id}/")
    public ResponseEntity<Object> delete(
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
