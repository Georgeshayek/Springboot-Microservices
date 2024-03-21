package com.example.coursemicroservice.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("enrollment-service")
public interface EnrollmentClient {
    @GetMapping("/enrollments/courses/{id}/students")
    List<Object> getAllStudentEnrolledToCourse(@PathVariable int id);
}
