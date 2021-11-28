package com.example.notendurchschnitt2.Note.model;


import com.example.notendurchschnitt2.common.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Note extends BaseEntity<Long> {

    private String fach;

    private double numericNote;

    public Note(String fach, double note){
        this.fach = fach;
        this.numericNote = note;
    }

    public Note(){
        this.fach = "";
        this.numericNote = 0.0;
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public double getNumericNote() {
        return numericNote;
    }

    public void setNumericNote(double numericNote) {
        this.numericNote = numericNote;
    }
}
