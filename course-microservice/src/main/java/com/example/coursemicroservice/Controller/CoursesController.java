package com.example.coursemicroservice.Controller;

import com.example.coursemicroservice.Model.Course;
import com.example.coursemicroservice.Service.CourseRequest;
import com.example.coursemicroservice.Service.CourseService;
import com.example.coursemicroservice.Service.EnrollmentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CourseService service;
    private final EnrollmentClient enrollmentClient;
    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> list=new ArrayList<>();
        list=service.getAllList();

        return list!=null? ResponseEntity.ok(service.getAllList()): ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/{id}/students")
    public ResponseEntity<Object> GetAllStudentEnrolled(@PathVariable int id){
       return ResponseEntity.ok(enrollmentClient.getAllStudentEnrolledToCourse(id));
    }
    @PostMapping("/")
    public  ResponseEntity<String> addCourse(@RequestBody CourseRequest request)
    {

        return ResponseEntity.ok(service.addCourse(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){

        return service.findById(id)!=null? ResponseEntity.ok(service.findById(id)):ResponseEntity.notFound().build();

    }
}
