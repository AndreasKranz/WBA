package com.example.notendurchschnitt2.Note.service;

import com.example.notendurchschnitt2.Note.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotenService {

    private static final Logger log = LoggerFactory.getLogger(NotenService.class);

    /*@PostConstruct
    public void postConstruct(){
        log.info("postConstruct() ArrayList of noten <double>");
        noten.add(1.0);
        noten.add(3.0);
        noten.add(2.0);

    }*/

    public void addNote(List<Note> arrList, String fach, double inputNote){
        arrList.add(erzeugeNote(fach,inputNote));
    }

    public Note erzeugeNote(String fach, double note){
        return new Note(fach,note);
    }

    public double getDurchschnitt(List<Note> arrList){
        double summe = 0.0;
        for (Note n : arrList){
            summe += n.getNumericNote();
        }
        return summe / arrList.size();
    }


}


