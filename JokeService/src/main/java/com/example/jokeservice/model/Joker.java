package com.example.jokeservice.model;

import com.example.jokeservice.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Joker extends BaseEntity<Long> {

    private String name;

    @OneToMany(mappedBy = "joker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Joke> jokes;



    @OneToMany(mappedBy = "joker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Joke> darkJokes;

    public Joker() {
        this.jokes = new ArrayList<>();
        this.darkJokes = new ArrayList<>();
    }

    public void addJoke(Joke joke){
        if(joke.getRated() == Rating.dark) {
            this.darkJokes.add(joke);
        } else {
            this.jokes.add(joke);
        }
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public List<Joke> getDarkJokes() {
        return darkJokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }

    public void setDarkJokes(List<Joke> darkJokes) {
        this.darkJokes = darkJokes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
