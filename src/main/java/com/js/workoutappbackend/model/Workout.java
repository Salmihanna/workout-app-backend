package com.js.workoutappbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "workout_name")
    private String workoutName;
    private String description;

//    @ManyToMany
//    @JoinTable(
//            name = "workout_with_exercises",
//            joinColumns = @JoinColumn(name = "workout_id"),
//            inverseJoinColumns = @JoinColumn(name = "exercise_id")
//    )
//    private Set<Exercise> workoutWithExercises;

    public Workout(String workoutName, String description) {
        this.workoutName = workoutName;
        this.description = description;
    }
}
