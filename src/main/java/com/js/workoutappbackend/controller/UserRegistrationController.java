package com.js.workoutappbackend.controller;

import com.js.workoutappbackend.model.MyUserDetails;
import com.js.workoutappbackend.model.User;
import com.js.workoutappbackend.model.UserRegistrationRequest;
import com.js.workoutappbackend.security.ApplicationUserRole;
import com.js.workoutappbackend.security.jwt.AuthenticationRequest;
import com.js.workoutappbackend.security.jwt.AuthenticationResponse;
import com.js.workoutappbackend.service.MyUserDetailService;
import com.js.workoutappbackend.security.jwt.JwtUtil;
import com.js.workoutappbackend.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) throws Exception
    {

        myUserDetailService.signUpUser(new User(
                userRegistrationRequest.getFirstName(),
                userRegistrationRequest.getLastName(),
                userRegistrationRequest.getEmail(),
                userRegistrationRequest.getUsername(),
                userRegistrationRequest.getPassword(),
                ApplicationUserRole.USER
        ));
        return createAuthenticationToken(userRegistrationRequest.getUsername());
    }

    public ResponseEntity<?> createAuthenticationToken(String username) throws Exception  {

        final MyUserDetails myUserDetails = (MyUserDetails) myUserDetailService.loadUserByUsername(username);

        final String jwt = jwtUtil.generateToken(myUserDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
