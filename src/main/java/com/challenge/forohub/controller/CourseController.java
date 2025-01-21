package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Course;
import com.challenge.forohub.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final ICourseService iCourseService;

    @Autowired
    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> courses() {
        return ResponseEntity.status(HttpStatus.OK).body(iCourseService.courses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> courseDetail(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iCourseService.courseById(id));
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCourseService.actualizar(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        iCourseService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCourseService.guardar(course));
    }
}
