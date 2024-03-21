package com.example.enrollementmicroservice.Controller;

import com.example.enrollementmicroservice.Model.Course;
import com.example.enrollementmicroservice.Model.Enrollement;
import com.example.enrollementmicroservice.Model.Student;
import com.example.enrollementmicroservice.Repository.EnrollementRepository;
import com.example.enrollementmicroservice.Service.EnrollmentService;
import com.example.enrollementmicroservice.Service.StudentClient;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Template;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;
    private final EnrollementRepository repository;
    private final RestTemplate restTemplate;
    private final StudentClient studentClient;
    @PostMapping
    public ResponseEntity<Enrollement> enrollStudent(@RequestBody RequestEnrollement enrollment){

        if (isValidStudent(enrollment.getStudentId()) && isValidCourse(enrollment.getCourseId())) {
            var enr= Enrollement.builder().studentId(enrollment.getStudentId()).courseId(enrollment.getCourseId()).build();
            return ResponseEntity.ok(repository.save(enr));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping
    public ResponseEntity<List<Enrollement>> getAllEnrollment()
    {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/student/{id}/courses")
    public ResponseEntity<List<Course>> getAllCourses(@PathVariable int id){
            return ResponseEntity.ok(service.getAllCourses(id));
    }
    @GetMapping("/courses/{id}/students")
    public ResponseEntity<List<Student>> getStudentEnrolledByCourse(@PathVariable int id){
        List<Enrollement> enrollements=new ArrayList<>();
        List<Student> students=new ArrayList<>();
        enrollements=repository.findByCourseId(id);
        for(Enrollement enroll:enrollements){
            students.add(studentClient.getStudentEnrolledTocourse(enroll.getStudentId()));
        }

        return ResponseEntity.ok(students);
    }
    private boolean isValidStudent(int studentId) {
        return restTemplate.getForEntity("http://student-service/students/" + studentId, Student.class).getStatusCode() == HttpStatus.OK;
    }

    private boolean isValidCourse(int courseId) {
        return restTemplate.getForEntity("http://course-service/courses/" + courseId, Course.class).getStatusCode() == HttpStatus.OK;
    }

}
