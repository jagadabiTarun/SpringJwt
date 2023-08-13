package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.LoginResponse;
import com.example.demo.database.UserStorage;
import com.example.demo.database.Users;
import com.example.demo.service.AuthorizationService;



@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private AuthorizationService authenticationService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody UserStorage body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword(),body.getEmail());
    }
    
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody UserStorage body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}   