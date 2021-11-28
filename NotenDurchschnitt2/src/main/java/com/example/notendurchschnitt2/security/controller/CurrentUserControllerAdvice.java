package com.example.notendurchschnitt2.security.controller;

import com.example.notendurchschnitt2.security.model.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CurrentUserControllerAdvice {

    @Autowired
    CurrentUser currentUser;

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser() {
        return currentUser;
    }
}
