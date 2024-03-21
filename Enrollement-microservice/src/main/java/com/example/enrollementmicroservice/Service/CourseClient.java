package com.example.enrollementmicroservice.Service;

import com.example.enrollementmicroservice.Model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CourseClient {
    private final RestTemplate restTemplate;

    public Course getCourseById(int courseId) {
        ResponseEntity<Course> responseEntity = restTemplate.getForEntity("http://course-service/courses/" + courseId, Course.class);
        return responseEntity.getBody();
    }
}
