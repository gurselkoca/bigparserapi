package com.intellibus.bigparser.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BigparserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigparserApiApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
