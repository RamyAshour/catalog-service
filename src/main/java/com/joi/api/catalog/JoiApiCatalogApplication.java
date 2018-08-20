package com.joi.api.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JoiApiCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoiApiCatalogApplication.class, args);
    }
}
