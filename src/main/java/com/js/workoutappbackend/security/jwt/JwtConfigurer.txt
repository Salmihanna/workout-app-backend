package com.js.workoutappbackend.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtTokenProvider jwtTokenProvider;

    public JwtConfigurer(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //Fortsätt HÄR!!! https://steve-mu.medium.com/implement-jwt-in-spring-boot-react-493d9a7a6568
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
//        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//    }
}
