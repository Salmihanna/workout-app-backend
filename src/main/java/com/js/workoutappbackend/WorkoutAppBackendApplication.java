package com.js.workoutappbackend;

import com.js.workoutappbackend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WorkoutAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkoutAppBackendApplication.class, args);
    }

}
