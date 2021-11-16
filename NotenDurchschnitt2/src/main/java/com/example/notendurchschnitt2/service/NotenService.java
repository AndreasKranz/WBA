package com.example.notendurchschnitt2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class NotenService {

    private static final Logger log = LoggerFactory.getLogger(NotenService.class);

    private ArrayList<Double> noten = new ArrayList<>();

    @PostConstruct
    public void postConstruct(){
        log.info("postConstruct() ArrayList of noten <double>");
        noten.add(1.0);
        noten.add(3.0);
        noten.add(2.0);

    }

    public void addNote(double inputNote){
        noten.add(inputNote);
    }

    public double getDurchschnitt(){
        double summe = 0.0;
        for (double n : noten){
            summe += n;
        }
        return summe / noten.size();
    }


}


