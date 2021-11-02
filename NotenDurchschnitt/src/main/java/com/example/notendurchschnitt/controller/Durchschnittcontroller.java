package com.example.notendurchschnitt.controller;

import com.example.notendurchschnitt.service.NotenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Durchschnittcontroller {

    @Autowired
    private NotenService notenService;

    public void fuegeNoteZu(double note){
        notenService.addNote(note);
    }

    public Double drawDurchschnitt(){
        notenService.berechneDurchschnitt();
        return notenService.getDurchschnitt();
    }
}
