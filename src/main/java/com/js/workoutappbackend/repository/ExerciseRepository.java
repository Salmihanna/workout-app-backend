package com.js.workoutappbackend.repository;

import com.js.workoutappbackend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query(value = "SELECT * FROM exercise e " +
            "JOIN workout_with_exercises w " +
            "ON e.id = w.exercise_id " +
            "WHERE w.workout_id = ?1", nativeQuery=true )
    List<Exercise> findAllByWorkoutId(Long workoutId);
}