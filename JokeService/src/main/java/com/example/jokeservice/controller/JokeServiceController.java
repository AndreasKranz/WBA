package com.example.jokeservice.controller;


import com.example.jokeservice.model.Joke;
import com.example.jokeservice.model.Rating;
import com.example.jokeservice.service.JokeRService;
import com.example.jokeservice.service.dto.InputDTO;
import com.example.jokeservice.service.dto.JokeResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/laugh")
public class JokeServiceController {

    private static final Logger log = LoggerFactory.getLogger(JokeServiceController.class);

    private JokeRService jokeRService;

    @Autowired
    public JokeServiceController(JokeRService jokeRService){
        this.jokeRService = jokeRService;
    }

    @RequestMapping(value = "/joke", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> drawJoke(){
        log.debug("@Controller: Versuch Joke zu returnen");
        String joke = jokeRService.getRandomJoke();
        return ResponseEntity.status(HttpStatus.OK).body(new JokeResponseDTO(joke));
    }

    @RequestMapping(value = "/darkjoke", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> drawDarkJoke(){
        log.debug("@Controller: Versuch dark Joke zu returnen");
        String joke = jokeRService.getRandomDarkJoke();
        return ResponseEntity.status(HttpStatus.OK).body(new JokeResponseDTO(joke));
    }

    @RequestMapping(value = "/comedian", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addJoke(@RequestBody InputDTO input){
        log.debug("@Controller: Versuch enum von Joke zu bestimmen");
        String inputJoke = input.getJoke();
        if (input.getRating().equals(Rating.unproblematic)) {
            log.debug("@Controller:Versuch Joke zu adden");
            jokeRService.addJoke(new Joke(inputJoke,Rating.unproblematic));
            return ResponseEntity.status(HttpStatus.CREATED).body(new JokeResponseDTO("Joke successfully added as \"unproblematic\""));
        } else if (input.getRating().equals(Rating.dark)){
            log.debug("@Controller:Versuch dark Joke zu adden!");
            jokeRService.addJoke(new Joke(inputJoke,Rating.dark));
            return ResponseEntity.status(HttpStatus.CREATED).body(new JokeResponseDTO("Joke successfully added as \"dark\""));
        } else {
            log.debug("@Controller: Error enum Vergleich zum adden gefailed!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JokeResponseDTO("Could not add joke!"));
        }
    }
}
