package com.example.beancounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondService {

    @Autowired
    CounterService counterService;

    public void doSomething(){
        counterService.count();
    }
}
