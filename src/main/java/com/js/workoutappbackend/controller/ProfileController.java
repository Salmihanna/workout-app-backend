package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.User;
import com.js.workoutappbackend.repository.UserRepository;
import com.js.workoutappbackend.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class ProfileController {

    private final UserRepository userRepository;

    @CrossOrigin
    @GetMapping(path = "/profile")
    public Optional<User> getProfile(@RequestParam Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
}