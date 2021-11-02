package com.example.notendurchschnitt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotenDurchschnittApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotenDurchschnittApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Hello World");
            }
        };
        return action;
    }
}
