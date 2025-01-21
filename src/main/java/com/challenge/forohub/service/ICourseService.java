package com.challenge.forohub.service;

import com.challenge.forohub.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICourseService {
    Course guardar(Course course);

    List<Course> courses();

    Course courseById(Long id);

    Course actualizar(Course course);

    void eliminar(Long id);
}
