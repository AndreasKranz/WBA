package com.example.jokeservice.service;

import com.example.jokeservice.model.Joke;

public interface JokeRService {

    void addJoke(Joke joke);

    String getRandomJoke();

    String getRandomDarkJoke();
}
