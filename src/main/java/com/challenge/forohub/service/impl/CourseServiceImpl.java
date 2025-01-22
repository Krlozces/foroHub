package com.challenge.forohub.service.impl;

import com.challenge.forohub.entity.Course;
import com.challenge.forohub.repository.ICourseRepository;
import com.challenge.forohub.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository iCourseRepository;

    @Autowired
    public CourseServiceImpl(ICourseRepository iCourseRepository) {
        this.iCourseRepository = iCourseRepository;
    }

    @Override
    public Course guardar(Course course) {
        if (iCourseRepository.findByName(course.getName()) != null) {
            return null;
        }

        if (Optional.ofNullable(course.getName()).orElse("").isBlank() || Optional.ofNullable(course.getCategory()).orElse("").isBlank()) {
            return null;
        }
        return iCourseRepository.save(course);
    }

    @Override
    public List<Course> courses() {
        return iCourseRepository.findAll();
    }

    @Override
    public Course courseById(Long id) {
        Optional<Course> course = iCourseRepository.findById(id);
        if (course.isPresent()) {
           return course.get();
        }
        return null;
    }

    @Override
    public Course actualizar(Course course) {
        if (!iCourseRepository.existsById(course.getId())) {
            return null;
        }

        Optional<Course> savedData = iCourseRepository.findById(course.getId());
        if (savedData.isPresent()) {
            if (Optional.ofNullable(course.getName()).orElse("").isBlank()) {
                course.setName(savedData.get().getName());
            }
            if (Optional.ofNullable(course.getCategory()).orElse("").isBlank()) {
                course.setCategory(savedData.get().getCategory());
            }
        }

        Course courseName = iCourseRepository.findByName(course.getName());
        if (courseName != null && !courseName.getId().equals(course.getId())) {
            return null;
        }

        if (Optional.ofNullable(course.getName()).orElse("").isBlank() || Optional.ofNullable(course.getCategory()).orElse("").isBlank()) {
            return null;
        }
        return iCourseRepository.save(course);
    }

    @Override
    public void eliminar(Long id) {
        Course course = iCourseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con el id: " + id));

        if (course.getTopics() != null && !course.getTopics().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar cursos con tópicos asociados.");
        }
        iCourseRepository.deleteById(id);
    }
}
