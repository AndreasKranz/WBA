package com.example.notendurchschnitt2.Note.controller;

import com.example.notendurchschnitt2.Note.model.Note;
import com.example.notendurchschnitt2.Note.service.NotenService;
import com.example.notendurchschnitt2.security.model.CurrentUser;
import com.example.notendurchschnitt2.security.model.User;
import com.example.notendurchschnitt2.security.service.user.UserService;
import com.example.notendurchschnitt2.security.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NotenController {

    private static final Logger log = LoggerFactory.getLogger(NotenController.class);

    private NotenService notenService;

    private UserService userService;

    private CurrentUser currentUser;

    @Autowired
    public NotenController(UserService securityUserService, NotenService notenService, CurrentUser currentUser) {
        this.userService = securityUserService;
        this.notenService = notenService;
        this.currentUser = currentUser;
    }


    public void fuegeNoteZu(String fach, double note) {
        User temp = currentUser.getUser();
        userService.addNote(temp,new Note(fach,note,temp));
    }

    @RequestMapping(value = "/first", method = {RequestMethod.GET, RequestMethod.POST})
    public String firstPage(@RequestParam String email, @RequestParam String password, Model model) {
        log.debug("/first --> log in with email " + email + " and password " + password);
        if (!userService.existsByEmail(email)) {
            log.debug("/first --> email was wrong!");
            model.addAttribute("error", "wrong login");
            return "login";
        }
        if (!password.equals(userService.getUserByEmail(email).get().getPassword())) {
            log.debug("/first --> password was wrong!");
            model.addAttribute("error", "wrong login");
            return "login";
        }
        currentUser.setUser(userService.getUserByEmail(email).get());


        return "main";
    }

    @PostMapping("/durchschnitt")
    public String berechneDurchschnitt(@RequestParam String notenFach,@RequestParam String notenEingabe, Model model) {
        double input = Double.parseDouble(notenEingabe);

        if (input != 0.1) {
            fuegeNoteZu(notenFach, input);
        }
        double avg = drawDurchschnitt(currentUser.getUser().getNotenListe());
        String durchschnitt = String.valueOf(avg);
        model.addAttribute("average", durchschnitt);

        return "main";
    }

    public double drawDurchschnitt(List<Note> arrInput) {
        return notenService.getDurchschnitt(arrInput);
    }
}
