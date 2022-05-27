package com.js.workoutappbackend.repository;

import com.js.workoutappbackend.model.Exercise;
import com.js.workoutappbackend.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Query(value = "SELECT * FROM workout w " +
            "JOIN user_and_workout u " +
            "ON w.id = u.workout_id " +
            "WHERE u.user_id = ?1", nativeQuery=true)
    List<Workout> findWorkoutByUser(Long userId);

    Workout getWorkoutById(Long id);
}
