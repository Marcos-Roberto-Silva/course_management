package br.com.inovacode.course_menagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inovacode.course_menagement.modules.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{
    
}
