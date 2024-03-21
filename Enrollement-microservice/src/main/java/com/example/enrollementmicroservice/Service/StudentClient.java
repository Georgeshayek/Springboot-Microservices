package com.example.enrollementmicroservice.Service;

import com.example.enrollementmicroservice.Model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("student-service")
public interface StudentClient {
    @GetMapping("/students/{id}")
Student getStudentEnrolledTocourse (@PathVariable int id);
}
