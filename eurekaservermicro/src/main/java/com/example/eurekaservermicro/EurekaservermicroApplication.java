package com.example.eurekaservermicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaservermicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaservermicroApplication.class, args);
    }

}
