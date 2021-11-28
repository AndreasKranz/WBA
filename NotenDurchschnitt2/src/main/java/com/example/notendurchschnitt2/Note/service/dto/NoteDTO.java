package com.example.notendurchschnitt2.Note.service.dto;

public class NoteDTO {

    private String fach;

    private double numericNote;

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
