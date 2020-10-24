package com.casestudy.creditapplicationbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.casestudy.creditapplicationbackend.repository")
public class CreditapplicationBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditapplicationBackendApplication.class, args);
    }

}
