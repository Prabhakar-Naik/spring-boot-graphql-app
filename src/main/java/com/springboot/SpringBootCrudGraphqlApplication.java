package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudGraphqlApplication.class, args);
        System.out.println("GraphQL Application Running...!");
    }

}
