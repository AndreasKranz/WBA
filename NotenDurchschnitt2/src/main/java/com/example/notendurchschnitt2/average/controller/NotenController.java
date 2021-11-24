package com.example.notendurchschnitt2.average.controller;

import com.example.notendurchschnitt2.average.service.NotenService;
import com.example.notendurchschnitt2.average.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotenController {

    private static final Logger log = LoggerFactory.getLogger(NotenController.class);

    @Autowired
    NotenService notenService;

    @Autowired
    UserService userService;

    public void addNote(double note){
        notenService.addNote(note);
    }

    @RequestMapping(value = "/first", method = {RequestMethod.GET, RequestMethod.POST})
    public String firstPage(@RequestParam String email, @RequestParam String password, Model model){
        log.debug("/first --> log in with email " + email + " and password " + password);
        if(!userService.existsByEmail(email)){
            log.debug("/first --> email was wrong!");
            model.addAttribute("error","wrong login");
        }


        return "";
    }

    @RequestMapping("/durchschnitt")
    public String berechneDurchschnitt(@RequestParam(value = "notenEingabe",required = false,defaultValue = "0.1")String notenEingabe, Model model){
        double input = Double.valueOf(notenEingabe);

        if(input != 0.1){
        addNote(input);
        }
        double avg = drawDurchschnitt();
        String durchschnitt = String.valueOf(avg);
        model.addAttribute("average",durchschnitt);

        return "main";
    }

    public double drawDurchschnitt(){
        return notenService.getDurchschnitt();
    }
}
