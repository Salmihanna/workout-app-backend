package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.Exercise;
import com.js.workoutappbackend.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ExerciseController {

    //get Home
    @GetMapping("/")
    public String home() {
      return ("<h1>Welcome</h1>");
    };

    //get user
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome user</h1>");
    };

    //get admin
    @GetMapping("/admin" )
    public String admin() {
        return ("<h1>Welcome admin</h1>");
    };


}
