package com.example.jokeservice.config;

import com.example.jokeservice.model.Joke;
import com.example.jokeservice.model.Joker;
import com.example.jokeservice.model.Rating;
import com.example.jokeservice.repository.JokeRepository;
import com.example.jokeservice.repository.JokerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired
    private JokerRepository jokeRRepository;

    @Autowired
    private JokeRepository jokeRepository;

    @PostConstruct
    public void init() {

        log.debug(">>> DB initialized");

        Joker jokeR = new Joker();
        jokeR.setName("Harald");
        jokeRRepository.save(jokeR);

        Joke joke1 = new Joke("Warum trinken Mäuse keinen Alkohol.\n Weil sie Angst vor dem Kater haben.", Rating.unproblematic,jokeR);
        Joke joke2 = new Joke("Polizeikontrolle! Alkohol, Drogen?\n Verkaufen Sie auch Pommes?", Rating.unproblematic,jokeR);
        Joke joke3 = new Joke("Der Arzt zum Patienten: \"Leider kann ich die Ursache Ihrer Krankheit nicht finden, " +
                "aber vielleicht liegt es am Alkohol.\" \n \"Gut, dann komme ich wieder, wenn Sie nüchtern sind!\"", Rating.unproblematic,jokeR);
        Joke joke4 = new Joke("\"Also, mein Lieber, mit Ihren Gallensteinen dürfen Sie keinen Alkohol mehr trinken!\" \n" +
                "\"Das versteh ich nicht, Herr Doktor, es heißt doch immer: Steter Tropfen höhlt den Stein!\"", Rating.unproblematic,jokeR);
        Joke joke5 = new Joke("Ist man gleich ein Rassist, nur weil man keinen schwarzen Humor mag?", Rating.dark,jokeR);
        Joke joke6 = new Joke("Was macht ein Leprakranker, wenn er einen tollen Witz hört?\n" +
                "Er lacht sich den Arsch ab.", Rating.dark,jokeR);
        Joke joke7 = new Joke("Treffen sich 2 Jäger im Wald. Sagt der eine zum anderen: \"Du, ich hab grad deine Frau getroffen.\"\n" +
                "Daraufhin der andere: \"Wo denn?\"\n" +
                "\"Genau zwischen den Augen!\"", Rating.dark,jokeR);
        jokeRepository.save(joke1);
        jokeRepository.save(joke2);
        jokeRepository.save(joke3);
        jokeRepository.save(joke4);
        jokeRepository.save(joke5);
        jokeRepository.save(joke6);
        jokeRepository.save(joke7);

        jokeR.addJoke(joke1);
        jokeR.addJoke(joke2);
        jokeR.addJoke(joke3);
        jokeR.addJoke(joke4);
        jokeR.addJoke(joke5);
        jokeR.addJoke(joke6);
        jokeR.addJoke(joke7);

        log.debug("Size der SCHEISSE " + jokeR.getJokes().size());
        log.debug("SIZE DER DUNKLEN SCHEISSE " + jokeR.getDarkJokes().size());
        jokeRRepository.save(jokeR);


    }
}
