package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.UserRegistrationRequest;
import com.js.workoutappbackend.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistrationService userRegistrationService;

    @PostMapping
    public void register(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "www.google.se");
        httpServletResponse.setStatus(302);
        //return userRegistrationService.register();
    }



    /*@GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return userRegistrationService.confirmToken(token);
    }*/
}
