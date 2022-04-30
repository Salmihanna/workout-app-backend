package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.SignIn;
import com.js.workoutappbackend.model.UserRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
public class SignInController {

     @PostMapping
    public String signIn(@RequestBody SignIn signIn) {
         System.out.println(signIn.getEmail() + " " + signIn.getPassword());
         return "";
     }
}
