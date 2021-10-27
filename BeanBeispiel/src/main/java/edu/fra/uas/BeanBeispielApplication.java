package edu.fra.uas;


import edu.fra.uas.controller.BeanController;
import edu.fra.uas.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class BeanBeispielApplication {

    private static final Logger log = LoggerFactory.getLogger(BeanBeispielApplication.class);

    @Autowired
    private BeanController beanController;

    @Autowired
    private MessageService messageService;

    public static void main(String[] args) {
        SpringApplication.run(BeanBeispielApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {


            @Override
            public void run(String... args) throws Exception {
                log.debug(beanController.putMessage("Hallo Welt"));
                log.debug(beanController.putMessage("--> OOOHOOO <--"));
                //messageService.getMessage();
                //messageService.setMessage("TestEingabe");
                //System.out.println(messageService.getMessage());
            }

        };
        return action;
    }


}

