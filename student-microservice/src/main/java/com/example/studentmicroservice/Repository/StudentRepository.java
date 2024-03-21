package com.example.studentmicroservice.Repository;

import com.example.studentmicroservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findStudentById(int id);
    Optional<Student> findStudentByName(String name);
}
