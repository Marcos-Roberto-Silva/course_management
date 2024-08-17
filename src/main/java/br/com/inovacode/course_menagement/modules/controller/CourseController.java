package br.com.inovacode.course_menagement.modules.controller;

import br.com.inovacode.course_menagement.exceptions.CourseFoundException;
import br.com.inovacode.course_menagement.useCases.CreateCourseUseCase;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
          var result = this.createCourseUseCase.execute(courseEntity);
          return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
