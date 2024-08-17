package br.com.inovacode.course_menagement.modules.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class CourseController {
    
    @PostMapping("path")
    public void create(@RequestBody String entity) {
        //TODO: process POST request
    }
    
}
