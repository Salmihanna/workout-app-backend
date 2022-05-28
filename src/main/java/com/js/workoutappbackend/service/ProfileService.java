package com.js.workoutappbackend.service;

import com.js.workoutappbackend.model.Workout;
import com.js.workoutappbackend.repository.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {

    private WorkoutRepository workoutRepository;

//    public List<Workout> getWorkoutsByUser(Long id) {
//
//    }
}
