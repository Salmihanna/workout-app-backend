package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.UserRegistrationRequest;
import com.js.workoutappbackend.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistrationService userRegistrationService;

    @PostMapping
    public String register(@RequestBody UserRegistrationRequest request) {
        return userRegistrationService.register(request);
    }



    /*@GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return userRegistrationService.confirmToken(token);
    }*/
}
