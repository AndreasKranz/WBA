package com.example.beancounter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CounterService {

    private static final Logger log = LoggerFactory.getLogger(CounterService.class);

    private int counter;

    public void count(){
        log.info("---> incremented counter");
        counter++;
        log.info("--> counter after increment: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}
