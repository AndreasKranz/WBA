package com.example.jokeservice.service.dto;

import com.example.jokeservice.model.Rating;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class InputDTO implements Serializable {

    String joke;
    Rating rating;

    public InputDTO() {
    }

    public InputDTO(String joke, Rating rating) {
        this.joke = joke;
        this.rating = rating;
    }


}
