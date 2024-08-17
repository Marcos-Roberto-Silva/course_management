package br.com.inovacode.course_menagement.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inovacode.course_menagement.exceptions.CourseFoundException;
import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.repository.CourseRepository;

import java.util.List;

@Service
public class CourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName())
                .ifPresent((course) -> {
                    throw new CourseFoundException();
                });


        return this.courseRepository.save(courseEntity);
    }

    public List<CourseEntity> getCourses() {
        return this.courseRepository.findAll();
    }
}
