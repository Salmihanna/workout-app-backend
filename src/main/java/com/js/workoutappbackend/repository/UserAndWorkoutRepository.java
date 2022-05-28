package com.js.workoutappbackend.repository;

import com.js.workoutappbackend.model.UserAndWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAndWorkoutRepository extends JpaRepository<UserAndWorkout, Long> {
    @Query(value = "SELECT * FROM workout w " +
            "JOIN user_and_workout u " +
            "ON w.id = u.workout_id " +
            "WHERE u.user_id = ?1", nativeQuery=true)
    List<UserAndWorkout> findUserAndWorkoutByUser (Long userId);
}
