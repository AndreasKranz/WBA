package com.example.beancounter;

import com.example.beancounter.service.FirstService;
import com.example.beancounter.service.SecondService;
import com.example.beancounter.service.ThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanCounterApplication {

    @Autowired
    FirstService firstService;

    @Autowired
    SecondService secondService;

    @Autowired
    ThirdService thirdService;

    public static void main(String[] args) {
        SpringApplication.run(BeanCounterApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                firstService.run();
                secondService.doSomething();
                thirdService.doIt();
            }
        };
        return action;
    }

}
