package br.com.inovacode.course_menagement.modules.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import jakarta.validation.Valid;


@RestController
@RequestMapping("course")
public class CourseController {
    
    @PostMapping("/")
    public void create(@Valid @RequestBody CourseEntity courseEntity) {
        System.out.println("Course");
        System.out.println(courseEntity.getId());
    }
}
