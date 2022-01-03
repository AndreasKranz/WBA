package com.example.notendurchschnitt2.config;

import com.example.notendurchschnitt2.Note.model.Note;
import com.example.notendurchschnitt2.Note.repository.NoteRepository;
import com.example.notendurchschnitt2.security.model.Role;
import com.example.notendurchschnitt2.security.model.User;
import com.example.notendurchschnitt2.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    @PostConstruct
    public void init(){
        log.debug(" >>> init database");

        User user = new User();
        user.setNickname("admin");
        user.setEmail("admin@example.com");
        user.setPassword("admin");
        //user.setNotenListe(new ArrayList<Note>());
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        User user1 = new User();
        user1.setNickname("bob");
        user1.setEmail("bob@example.com");
        user1.setPassword("bob");
        //user.setNotenListe(new ArrayList<Note>());
        user1.setRole(Role.USER);
        userRepository.save(user1);
    }
}
