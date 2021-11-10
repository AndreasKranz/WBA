package com.example.notendurchschnitt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Noten {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Note> notenListe;

    public List<Note> getNotenListe() {
        return notenListe;
    }

    public void setNotenListe(List<Note> notenListe) {
        this.notenListe = notenListe;
    }

    public Noten() {
    }

    public Noten(List<Note> notenListe) {
        this.notenListe = notenListe;
    }
}
