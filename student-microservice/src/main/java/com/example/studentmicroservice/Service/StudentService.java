package com.example.studentmicroservice.Service;

import com.example.studentmicroservice.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import com.example.studentmicroservice.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
    public String CreateAStudent(RequestStudent request){
        Student student= Student.builder().name(request.getName()).age(request.getAge()).build();
        studentRepository.save(student);
        return "student with the name of" + request.getName()+ "have been succesfully created";
    }
    public Student findStudentbyId(int id){
        Student s=studentRepository.findStudentById(id).orElse(null);
        return s;
    }
}
