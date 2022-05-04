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
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
public class SignInController {

//     @PostMapping
//    public String signIn(@ModelAttribute("signin") SignIn signIn) {
//         System.out.println(signIn.getEmail() + " " + signIn.getPassword());
//         return "{\"success\": true}";
//     }

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtil;

    @PostMapping
public ResponseEntity<?> register(@RequestBody AuthenticationRequest authRequest) throws Exception  {
//    httpServletResponse.setHeader("Location", "www.google.se");
//    httpServletResponse.setStatus(302);
    //return userRegistrationService.register();
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    } catch (BadCredentialsException e) {
        throw new Exception("Incorrect username or password", e);
    }

    final MyUserDetails myUserDetails = (MyUserDetails) myUserDetailService.loadUserByUsername(authRequest.getUsername());
    final String jwt = jwtUtil.generateToken(myUserDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
}
}
