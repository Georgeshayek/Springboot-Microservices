package com.example.enrollementmicroservice.Service;

import com.example.enrollementmicroservice.Model.Course;
import com.example.enrollementmicroservice.Model.Enrollement;
import com.example.enrollementmicroservice.Repository.EnrollementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EnrollmentService {
    private final EnrollementRepository repository;
    private final CourseClient courseClient;
    public List<Course> getAllCourses (int id){
            List<Enrollement> enrollements= new ArrayList<>();
            enrollements=repository.findByStudentId(id);
            System.out.println(enrollements);
            List<Course> courses=new ArrayList<>();
            for(int i=0;i<enrollements.size();i++) {
                   Course course=courseClient.getCourseById(enrollements.get(i).getCourseId());
                    courses.add(course);
            }
            return courses;
    }

}
