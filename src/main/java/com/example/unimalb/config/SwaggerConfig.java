package com.example.unimalb.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
@RestController
public class SwaggerConfig {


@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build()
            .apiInfo(metaInfo());

}

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "University Of Malawi Loan Bonding API",
                "University Of Malawi Loan Bonding API CREATED Donnex Thyolera Kamsonga,  Language usered - JAVA ~ v11, Spring-Boot Framework with the following dependencies: Hibernate & Java Persistence API - JPA, Hypermedia As The Engine Of Application State - HATEOAS," +
                        "Build tool - MAVEN, developers website: https://thyolera-cv.netlify.app, email:bed-com-15-19@unima.ac.mw",
                "17",
                "https://thyolera-cv.netlify.app",
                "Kamsonga, website: https://thyolera-cv.netlify.app, email:bed-com-15-19@unima.ac.mw",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0"

        );
        return  apiInfo;
    }

}