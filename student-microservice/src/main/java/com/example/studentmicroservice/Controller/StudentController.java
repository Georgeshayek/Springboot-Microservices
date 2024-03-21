package com.example.studentmicroservice.Controller;

import com.example.studentmicroservice.Service.EnrollmentClient;
import com.example.studentmicroservice.Service.RequestStudent;
import com.example.studentmicroservice.Service.StudentService;
import lombok.RequiredArgsConstructor;
import com.example.studentmicroservice.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    private final EnrollmentClient enrollmentClient;
    @PostMapping
    public ResponseEntity <String> addStudent(@RequestBody RequestStudent request){

        return ResponseEntity.ok(service.CreateAStudent(request));
    }
    @GetMapping
    public ResponseEntity <List<Student>> GetAllStudents(){
        return ResponseEntity.ok(service.findAllStudent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){

        return service.findStudentbyId(id)!=null? ResponseEntity.ok(service.findStudentbyId(id)):ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Object>> GetAllCourses(@PathVariable  int id){
      return  ResponseEntity.ok(enrollmentClient.getAllCoursedEnrolledByStudent(id));

    }
}
