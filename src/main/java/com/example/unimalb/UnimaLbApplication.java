package com.example.unimalb;

import com.example.unimalb.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class UnimaLbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnimaLbApplication.class, args);

//		try {
//			SpringApplication.run(UnimaLbApplication.class, args);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
