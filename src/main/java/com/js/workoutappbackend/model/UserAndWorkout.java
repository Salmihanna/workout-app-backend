package com.js.workoutappbackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_and_workout")
public class UserAndWorkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
    @Column(name = "workout_performed")
    private LocalDateTime workoutPerformed;

    public UserAndWorkout(User user, Workout workout, LocalDateTime workoutPerformed) {
        this.user = user;
        this.workout = workout;
        this.workoutPerformed = workoutPerformed;
    }
}
