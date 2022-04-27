package com.js.workoutappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "exercise_name")
    private String exerciseName;
    @Column(name = "description")
    private String description;

    public Exercise() {
    }

    public Exercise(long id, String exerciseName, String description) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
