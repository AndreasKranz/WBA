package com.example.jokeservice.model;

import com.example.jokeservice.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Joke extends BaseEntity<Long> {

    private String joke;

    private Rating rated;

    //@JsonBackReference
    @ManyToOne
    private Joker joker;

    public Joke(String joke, Rating rated){
        this.joke = joke;
        this.rated = rated;
    }

    public Joke() {
        this.joke = "lul";
        this.rated = Rating.unproblematic;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Rating getRated() {
        return rated;
    }

    public void setRated(Rating rated) {
        this.rated = rated;
    }

    public Joker getJoker() {
        return joker;
    }
}
