package com.js.workoutappbackend.repository;

import com.js.workoutappbackend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}