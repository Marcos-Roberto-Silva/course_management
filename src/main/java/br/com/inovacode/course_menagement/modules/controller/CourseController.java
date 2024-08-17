package br.com.inovacode.course_menagement.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.repository.CourseRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    
    @PostMapping("/")
    public CourseEntity create(@Valid @RequestBody CourseEntity courseEntity) {
       return this.courseRepository.save(courseEntity);
    }
}
