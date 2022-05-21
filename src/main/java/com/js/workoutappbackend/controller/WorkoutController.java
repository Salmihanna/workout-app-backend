package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.Exercise;
import com.js.workoutappbackend.model.Workout;
import com.js.workoutappbackend.repository.ExerciseRepository;
import com.js.workoutappbackend.repository.WorkoutRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
public class WorkoutController {

    private WorkoutRepository workoutRepository;
    private ExerciseRepository exerciseRepository;

    // Get all workouts
    @CrossOrigin
    @GetMapping("/all-workouts")
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    // Get all exercise
    @CrossOrigin
    @GetMapping("/all-exercises")
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    // Get workout by id
    @CrossOrigin
    @GetMapping("/workout")
    public Optional<Workout> getExercisesByWorkout(@RequestParam Long id) {
        return workoutRepository.findById(id);
    }

    // get exercises by ids
    @CrossOrigin
    @GetMapping("/get-exercises")
    public List<Exercise> getExercisesFromWorkout(@RequestParam Long id) {
        return exerciseRepository.findAllByWorkoutId(id);
    }

}

