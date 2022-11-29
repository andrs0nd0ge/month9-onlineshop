package com.example.homework.controllers;

import com.example.homework.entity.User;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String redirectToMain(String email) {
        User userFromDb = userService.findUserByEmail(email);

        if(userFromDb == null){
            return "redirect:/";
        }
        return "login";
    }
}
