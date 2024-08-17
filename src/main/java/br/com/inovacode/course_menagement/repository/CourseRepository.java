package br.com.inovacode.course_menagement.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inovacode.course_menagement.modules.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{
    Optional<CourseEntity>  findByIdOrName(String id, String name);
}
