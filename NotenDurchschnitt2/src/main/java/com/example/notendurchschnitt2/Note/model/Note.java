package com.example.notendurchschnitt2.Note.model;


import com.example.notendurchschnitt2.common.BaseEntity;
import com.example.notendurchschnitt2.security.model.User;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Note extends BaseEntity<Long> {

    private String fach;

    private double numericNote;

    //test
    @ManyToOne
    private User user;

    public Note(String fach, double note,User user){
        this.fach = fach;
        this.numericNote = note;
        this.user = user;
    }

    public Note(){
        this.fach = "";
        this.numericNote = 0.0;
        this.user = new User();
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
