package com.example.enrollementmicroservice.Repository;

import com.example.enrollementmicroservice.Model.Enrollement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollementRepository extends JpaRepository<Enrollement,Integer> {
    Optional<Enrollement> findById(int i);
    Optional<Enrollement>findAllByCourseId(int id);
    List<Enrollement> findByStudentId(int id);
    List<Enrollement> findByCourseId(int id);
}
