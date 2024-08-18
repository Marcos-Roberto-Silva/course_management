package br.com.inovacode.course_menagement.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.useCases.CourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("course")
public class CreateCourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            CourseEntity createCourse = this.courseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(createCourse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
