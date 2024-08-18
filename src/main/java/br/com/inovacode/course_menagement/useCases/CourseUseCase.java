package br.com.inovacode.course_menagement.useCases;

import br.com.inovacode.course_menagement.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inovacode.course_menagement.exceptions.CourseFoundException;
import br.com.inovacode.course_menagement.modules.entities.CourseEntity;
import br.com.inovacode.course_menagement.repository.CourseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public CourseEntity updateCourse(UUID id, CourseEntity courseEntity) {
        Optional<CourseEntity> existingCourseOpt = courseRepository.findById(id);

        if (existingCourseOpt.isPresent()) {
            CourseEntity existingCourse = existingCourseOpt.get();

            existingCourse.setName(courseEntity.getName());
            existingCourse.setCategory(courseEntity.getCategory());
            existingCourse.setActive(courseEntity.getActive());
            return courseRepository.save(existingCourse);
        } else {
            throw new CourseNotFoundException("Course with ID " + id + " not registered.");
        }
    }

    public void deleteCourse(UUID id) {
        Optional<CourseEntity> existingCourseOpt = courseRepository.findById(id);

        if (existingCourseOpt.isPresent()) {
            courseRepository.deleteById(id);
        } else {
            throw new CourseNotFoundException("Course with ID " + id + " not registered.");
        }
    }

    public List<CourseEntity> getCourses() {
        return this.courseRepository.findAll();
    }
}
