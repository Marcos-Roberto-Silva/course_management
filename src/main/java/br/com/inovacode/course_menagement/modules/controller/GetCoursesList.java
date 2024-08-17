package br.com.inovacode.course_menagement.modules.controller;

import br.com.inovacode.course_menagement.useCases.CourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courses")
public class GetCoursesList {
    @Autowired
    private CourseUseCase courseUseCase;

    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            var result = this.courseUseCase.getCourses();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
