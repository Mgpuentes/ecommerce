package com.code4life.ecommerce.controller;

import com.code4life.ecommerce.model.User;
import com.code4life.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public String user(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping(value = "/user")
    public String userPost(@ModelAttribute("user") User user) {
        if(user != null) {
            User returned = userService.saveUser(user);
            LOG.debug("Created user is {}", returned);
        }
        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String getUsers(Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user";
    }

}
