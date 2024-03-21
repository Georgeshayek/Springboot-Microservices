package com.example.studentmicroservice.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("enrollment-service")
public interface EnrollmentClient {
    @GetMapping("/enrollments/student/{id}/courses")
    List<Object> getAllCoursedEnrolledByStudent(@PathVariable int id);
}
