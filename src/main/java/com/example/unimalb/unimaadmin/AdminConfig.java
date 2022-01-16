package com.example.unimalb.unimaadmin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner(AdminReposistory adminReposistory){
        return args -> {
            UnimalbAdmin donnex = new  UnimalbAdmin(
                    "Donnex Thyolera Kamsonga",
                    "donnex@donnex.com",
                    "demo"
            );
            UnimalbAdmin james = new  UnimalbAdmin(
                    "jamesThyolera Kamsonga",
                    "donnex@dunimalb.com",
                    "demo"
            );

            adminReposistory.saveAll(
                    List.of(
                            donnex, james
                    )
            );

        };
    }
}
