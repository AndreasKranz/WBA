package com.example.jokeservice.service.dto;

import com.example.jokeservice.model.Rating;

public class InputDTO {

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
