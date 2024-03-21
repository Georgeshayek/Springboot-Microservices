package com.example.coursemicroservice.Repository;

import com.example.coursemicroservice.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    Optional<Course> findById(Integer integer);
    Optional<Course> findByCourseName( String courseName);
 }
