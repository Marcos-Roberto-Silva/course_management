package br.com.inovacode.course_menagement.useCases;

import br.com.inovacode.course_menagement.exceptions.CourseFoundException;
import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByIdOrName(String.valueOf(courseEntity.getId()), courseEntity.getName())
                .ifPresent((course) -> {
                    throw new CourseFoundException();
                });


        return this.courseRepository.save(courseEntity);
    }
}
