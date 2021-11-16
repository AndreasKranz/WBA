package com.example.notendurchschnitt2.controller;

import com.example.notendurchschnitt2.service.NotenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotenController {

    @Autowired
    NotenService notenService;

    public void addNote(double note){
        notenService.addNote(note);
    }



    public double drawDurchschnitt(){
        return notenService.getDurchschnitt();
    }
}
