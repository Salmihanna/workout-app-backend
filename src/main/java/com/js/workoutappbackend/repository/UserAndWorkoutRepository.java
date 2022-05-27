package com.js.workoutappbackend.repository;

import com.js.workoutappbackend.model.UserAndWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAndWorkoutRepository extends JpaRepository<UserAndWorkout, Long> {

}
