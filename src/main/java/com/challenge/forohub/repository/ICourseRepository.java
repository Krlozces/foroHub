package com.challenge.forohub.repository;

import com.challenge.forohub.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
