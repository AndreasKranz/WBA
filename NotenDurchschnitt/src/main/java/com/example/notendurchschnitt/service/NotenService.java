package com.example.notendurchschnitt.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class NotenService {

    private ArrayList<Double> noten = new ArrayList<Double>();
    private double durchschnitt;

    public void addNote(double note){
        noten.add(note);
    }

    public void berechneDurchschnitt(){
        double summe = 0;
        for (double i : noten){
            summe += i;
        }
        this.durchschnitt = summe/ noten.size();
    }

    public double getDurchschnitt() {
        return durchschnitt;
    }
}