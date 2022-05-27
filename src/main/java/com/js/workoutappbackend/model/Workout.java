package com.js.workoutappbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private String image;
    private String category;
    private int duration;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "workout_with_exercises",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private Set<Exercise> workoutWithExercises;

    // @OneToMany(mappedBy = "workout")
    // private Set<UserAndWorkout> userAndWorkouts;

//    @ManyToMany(mappedBy = "userAndWorkout", fetch = FetchType.LAZY)
//    private Set<User> users;

    public Workout(String workoutName, String description, String image, String category, int duration) {
        this.workoutName = workoutName;
        this.description = description;
        this.image = image;
        this.category = category;
        this.duration = duration;
    }
}
