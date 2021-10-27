package edu.fra.uas.service;

import edu.fra.uas.BeanBeispielApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    private String message;

    public String getMessage() {
        log.debug("Message ist " + message);
        return message;
    }


    public void setMessage(String message) {
        log.debug("Message gesetzt als: " + message);
        this.message = message;
    }

}
