package com.js.workoutappbackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.js.workoutappbackend.model.SignIn;
import com.js.workoutappbackend.model.UserRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
public class SignInController {

//     @PostMapping
//    public String signIn(@ModelAttribute("signin") SignIn signIn) {
//         System.out.println(signIn.getEmail() + " " + signIn.getPassword());
//         return "{\"success\": true}";
//     }
@PostMapping
public void register(HttpServletResponse httpServletResponse) {
    httpServletResponse.setHeader("Location", "www.google.se");
    httpServletResponse.setStatus(302);
    //return userRegistrationService.register();
}
}
