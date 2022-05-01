package com.js.workoutappbackend.security.config;

import com.js.workoutappbackend.model.User;
import com.js.workoutappbackend.security.ApplicationUserRole;
import com.js.workoutappbackend.security.jwt.JwtTokenProvider;
import com.js.workoutappbackend.service.MyUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.js.workoutappbackend.security.ApplicationUserRole.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final MyUserDetailService myUserDetailService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
                //.antMatchers("/admin").hasRole(ADMIN.toString())
                //.antMatchers("/user").hasRole("USER")
                //.antMatchers("/api/v*/registration/**").permitAll()
                // DENNA ANVÄNDS! .antMatchers("/api/v1/login").permitAll().and().apply(new JwtConfigurer(jwtTokenProvider))
                /*.antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                */

    };

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(myUserDetailService);

        return provider;
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails benny = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                //.authorities(USER.getGrantedAuthorities())
//                .build();
//
//        UserDetails masterBenny = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                //.authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(benny);
//    };
}
