package com.example.jokeservice.model;

import com.example.jokeservice.common.BaseEntity;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Joke extends BaseEntity<Long> {

    private String joke;

    private Rating rated;

    @ManyToOne(cascade =  CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "joker_id", nullable = false, unique = true)
    private Joker joker;


    public void setJoker(Joker joker) {
        this.joker = joker;
    }

    /*
    @ManyToOne
    private Joker joker;
*/



    public Joke(String joke, Rating rated, Joker joker){
        this.joke = joke;
        this.rated = rated;
        this.joker = joker;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Joke joke = (Joke) o;
        return getId() != null && Objects.equals(getId(), joke.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
