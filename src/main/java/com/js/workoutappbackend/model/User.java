package com.js.workoutappbackend.model;

import com.js.workoutappbackend.security.ApplicationUserRole;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(name = "user_name")
    private String username;
    private String password;
    private boolean active = true;
    private boolean locked  = false;
    private ApplicationUserRole applicationUserRole;

    public User() {
    }

    public User( String firstName ,String lastName, String email, String username, String password,
                 ApplicationUserRole applicationUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.applicationUserRole = applicationUserRole;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {


        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ApplicationUserRole getRoles() {
        return applicationUserRole;
    }

    public void setRoles(ApplicationUserRole applicationUserRole) {
        this.applicationUserRole = applicationUserRole;
    }
}
