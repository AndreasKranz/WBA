package com.example.notendurchschnitt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Integer id;

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
