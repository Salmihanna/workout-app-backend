package com.js.workoutappbackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.js.workoutappbackend.model.MyUserDetails;
import com.js.workoutappbackend.model.SignIn;
import com.js.workoutappbackend.model.UserRegistrationRequest;
import com.js.workoutappbackend.security.jwt.AuthenticationRequest;
import com.js.workoutappbackend.security.jwt.AuthenticationResponse;
import com.js.workoutappbackend.security.jwt.JwtUtil;
import com.js.workoutappbackend.service.MyUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/api/v1/sign-in")
@AllArgsConstructor
public class SignInController {

//     @PostMapping
//    public String signIn(@ModelAttribute("signin") SignIn signIn) {
//         System.out.println(signIn.getEmail() + " " + signIn.getPassword());
//         return "{\"success\": true}";
//     }
    private final static String INCORRECT_MSG = "Incorrect username or password";
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtil;

    @PostMapping
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception  {
//    try {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//    } catch (BadCredentialsException e) {
//        throw new Exception(INCORRECT_MSG, e);
//    }


    final MyUserDetails myUserDetails = (MyUserDetails) myUserDetailService.loadUserByUsername(authRequest.getUsername());
    if (myUserDetailService.isValidUser(myUserDetails, authRequest.getPassword()) == false) {
        return null;
    }
    final String jwt = jwtUtil.generateToken(myUserDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
}
}
