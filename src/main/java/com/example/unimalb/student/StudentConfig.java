package com.example.unimalb.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
            Student Donnex =new Student(
                    "Donnex Thyolera Kamsonga",
                    "bed-com-15-19",
                    "bed-com-15-19@unima.ac.mw",
                    "upkeep",
                    true,
                    LocalDate.of(2019, Month.AUGUST,4),
                    "hello"
            );
            Student Edith =new Student(
                    "Edith Makhwe",
                    "bed-com-19-19",
                    "bed-com-19-19@unima.ac.mw",
                    "",
                    false,
                    LocalDate.of(2019, Month.AUGUST,4),
                    "edith"
            );

            repository.saveAll(
                    List.of(Donnex,Edith)
            );
        };
    }
}
