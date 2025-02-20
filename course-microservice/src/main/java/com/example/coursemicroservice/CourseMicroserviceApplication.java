package com.example.coursemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CourseMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseMicroserviceApplication.class, args);
    }

}
