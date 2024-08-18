package br.com.inovacode.course_menagement.modules.controller;

import br.com.inovacode.course_menagement.exceptions.NoCoursesFoundException;
import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.useCases.CourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class GetCoursesListController {
    @Autowired
    private CourseUseCase courseUseCase;

    @GetMapping("/")
    public ResponseEntity<Object> getCourses() {
        try {
            List<CourseEntity> courses = this.courseUseCase.getCourses();
            return ResponseEntity.ok().body(courses);
        } catch (NoCoursesFoundException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
