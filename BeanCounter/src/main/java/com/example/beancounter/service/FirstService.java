package com.example.beancounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    @Autowired
    CounterService counterService;

    public void run(){
        counterService.count();
    }
}
