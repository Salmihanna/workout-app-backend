package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.User;
import com.js.workoutappbackend.model.UserAndWorkout;
import com.js.workoutappbackend.model.Workout;
import com.js.workoutappbackend.repository.UserAndWorkoutRepository;
import com.js.workoutappbackend.repository.UserRepository;
import com.js.workoutappbackend.repository.WorkoutRepository;
import com.js.workoutappbackend.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class ProfileController {

    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;
    private final UserAndWorkoutRepository userAndWorkoutRepository;

    @CrossOrigin
    @GetMapping(path = "/profile")
    public Optional<User> getProfile(@RequestParam Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @CrossOrigin
    @GetMapping(path = "/workout-from-user")
    public List<Workout> getWorkoutsByUser(@RequestParam Long id) {
        return workoutRepository.findWorkoutByUser(id);
    }

    @CrossOrigin
    @GetMapping(path = "/user-and-workspace-from-user")
    public List<UserAndWorkout> getUserAndWorkoutsByUser(@RequestParam Long id) {
        return userAndWorkoutRepository.findUserAndWorkoutByUser(id);
    }
}