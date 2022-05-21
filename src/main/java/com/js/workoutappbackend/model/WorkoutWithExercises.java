//package com.js.workoutappbackend.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//public class WorkoutWithExercises {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(nullable = false, name = "workout_id")
//    private Workout workout;
//
//    @ManyToOne
//    @JoinColumn(nullable = false, name = "exercise_id")
//    private Exercise exercise;
//
//    public WorkoutWithExercises(Workout workout, Exercise exercise) {
//        this.workout = workout;
//        this.exercise = exercise;
//    }
//
//
//}
