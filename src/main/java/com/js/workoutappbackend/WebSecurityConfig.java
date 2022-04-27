package com.js.workoutappbackend;

import com.js.workoutappbackend.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

//    @Autowired
//    UserDetailsService userDetailsService;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService);
//    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails benny = User.builder()
                .username("Benny")
                .password(passwordEncoder.encode("123"))
                .roles(ApplicationUserRole.USER.name())
                .build();

        UserDetails masterBenny = User.builder()
                .username("Benny")
                .password(passwordEncoder.encode("123"))
                .roles(ApplicationUserRole.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(benny, masterBenny);
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasRole(ApplicationUserRole.ADMIN.name())
                .antMatchers("/user").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.USER.name())
                .antMatchers("/").permitAll()
                .and().formLogin();

    };
}
