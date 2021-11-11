package com.example.notendurchschnitt.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.notendurchschnitt.repository.*;


import javax.annotation.PostConstruct;

@Component
public class InitiliazeDB {

    private static final Logger log = LoggerFactory.getLogger(InitiliazeDB.class);

    @Autowired
    NotenRepository notenRepository;

    @Autowired
    NoteRepository noteRepository;

    @PostConstruct
    public void init()  {

    }


}
