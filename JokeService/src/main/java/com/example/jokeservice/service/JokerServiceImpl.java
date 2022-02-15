package com.example.jokeservice.service;

import com.example.jokeservice.model.Joke;
import com.example.jokeservice.model.Joker;
import com.example.jokeservice.model.Rating;
import com.example.jokeservice.repository.JokeRepository;
import com.example.jokeservice.repository.JokerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class JokerServiceImpl implements JokeRService{

    private static final Logger log = LoggerFactory.getLogger(JokerServiceImpl.class);
    @Autowired
    private JokerRepository jokeRRepository;

    @Autowired
    private JokeRepository jokeRepository;

    /*@Override
    public void addJoke(Joke joke) {
        Optional<Joker> jokeROptional = jokeRRepository.findByName("Harald");
        if(jokeROptional.isPresent()){
            log.debug("@Service:Versuch Joke zu adden");
            jokeROptional.get().addJoke(joke);
            jokeRepository.save(joke);
        } else {
            log.debug("@Service: Error: findByName not working!");
        }
    }*/

    @Override
    public void addJoke(String input, Rating rating) {
        Optional<Joker> jokeROptional = jokeRRepository.findByName("Harald");
        if(jokeROptional.isPresent()){
            Joker clown = jokeROptional.get();
            log.debug("@Service:Versuch Joke zu adden");
            Joke joke = new Joke(input,rating, clown);
            jokeROptional.get().addJoke(joke);
            jokeRepository.save(joke);
        } else {
            log.debug("@Service: Error: findByName not working!");
        }
    }

    @Override
    public String getRandomJoke() {
        Random rand = new Random();
        Optional<Joker> jokeROptional = jokeRRepository.findByName("Harald");
        //Joker joker = jokeRRepository.findByName("Harald");
        if(jokeROptional.isPresent()){
            List<Joke> temp = jokeROptional.get().getJokes();
            log.debug("@Service:Name " + jokeROptional.get().getName());
            log.debug("@Service:Size der LIST von Jokes "+temp.size());
            int index = rand.nextInt(temp.size());
            log.debug("@Service: Random Joke delivered!");
            return temp.get(index).getJoke();
        }
        log.debug("@Service: Delivery of random joke failed");
        return null;
    }

    @Override
    public String getRandomDarkJoke() {
        Random rand = new Random();
        Optional<Joker> jokeROptional = jokeRRepository.findByName("Harald");
        if(jokeROptional.isPresent()){
            List<Joke> temp = jokeROptional.get().getDarkJokes();
            int index = rand.nextInt(temp.size());
            log.debug("@Service: Random dark joke delivered!");
            return temp.get(index).getJoke();
        }
        log.debug("@Service: Delivery of random joke failed");
        return null;
    }
}
