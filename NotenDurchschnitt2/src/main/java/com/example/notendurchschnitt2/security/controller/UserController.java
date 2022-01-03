package com.example.notendurchschnitt2.security.controller;

import com.example.notendurchschnitt2.security.model.UserCreateForm;
import com.example.notendurchschnitt2.security.service.dto.UserDTO;
import com.example.notendurchschnitt2.security.service.user.UserService;
import com.example.notendurchschnitt2.security.service.validator.UserCreateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService securityUserService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = securityUserService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("myform")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping("/users")
    public String getUsersPage(Model model) {
        log.info("/users --> getting user page");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/users/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserPage(@PathVariable Long id, Model model) {
        log.debug("/users/" + id + " --> getting user page for user= " + id);
        UserDTO userDTO =
                userService.getUserById(id);
        model.addAttribute("user", userDTO);
        model.addAttribute("fromUser", userDTO.getNickname());
        return "user";
    }

    @RequestMapping(value = "/users/managed", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserManagedPage(Model model) {
        log.debug("/users/managed --> getting user create form");
        model.addAttribute("myform", new UserCreateForm());
        model.addAttribute("users", userService.getAllUsers());
        return "user_create";
    }

    @RequestMapping(value = "/usercreate", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("myform") UserCreateForm form, BindingResult bindingResult, Model model) {
        log.info("/users/create --> processing user create form= " + form + " bindingResult= " + bindingResult);
        model.addAttribute("users", userService.getAllUsers());
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
            return "user_create";
        }
        userService.create(form);
        return "redirect:/users/managed";
    }

}
