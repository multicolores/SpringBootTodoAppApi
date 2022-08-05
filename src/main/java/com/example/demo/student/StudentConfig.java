package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student paul = new Student("Paul", "paul@gmail.com", LocalDate.of(2000, Month.JANUARY,
                    5));

            Student alex = new Student("Alex", "alex@gmail.com", LocalDate.of(2001, Month.JANUARY,
                    3));

            repository.saveAll(List.of(paul, alex));

        };

    }
}
