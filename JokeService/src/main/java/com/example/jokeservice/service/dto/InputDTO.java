package com.example.jokeservice.service.dto;

import com.example.jokeservice.model.Rating;

import java.io.Serializable;

public class InputDTO implements Serializable {

    String joke;
    Rating rating;

    public InputDTO() {
    }

    public InputDTO(String joke, Rating rating) {
        this.joke = joke;
        this.rating = rating;
    }

    public String getJoke() {
        return joke;
    }

    public Rating getRating() {
        return rating;
    }
}
