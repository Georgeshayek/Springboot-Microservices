package com.example.coursemicroservice.Service;

import com.example.coursemicroservice.Model.Course;
import com.example.coursemicroservice.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
        private final CourseRepository repository;
        public List<Course> getAllList(){
            return repository.findAll();
        }
        public String addCourse(CourseRequest request){
            var course= Course.builder().courseName(request.getCourseName()).build();
            repository.save(course);
            return "course been saved";

    }
    public Course findById(int id){
            return repository.findById(id).orElse(null);
    }

}
