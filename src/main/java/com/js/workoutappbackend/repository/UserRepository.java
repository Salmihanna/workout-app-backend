package com.js.workoutappbackend.repository;

import com.js.workoutappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPassword(String password);


    @Transactional
    @Modifying
    @Query("UPDATE User u " +
            "SET u.active = TRUE " +
            "WHERE u.email = ?1 ")
    int activateUser(String email);
}
