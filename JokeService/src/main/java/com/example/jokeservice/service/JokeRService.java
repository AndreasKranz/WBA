package com.example.jokeservice.service;

import com.example.jokeservice.model.Rating;

public interface JokeRService {

    void addJoke(String input, Rating rating);

    String getRandomJoke();

    String getRandomDarkJoke();
}
