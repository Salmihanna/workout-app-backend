package com.js.workoutappbackend.service;

import com.js.workoutappbackend.model.ConfirmationToken;
import com.js.workoutappbackend.model.MyUserDetails;
import com.js.workoutappbackend.model.User;
import com.js.workoutappbackend.repository.UserRepository;
import com.js.workoutappbackend.security.ApplicationPasswordConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with username %s not found";
    private final static String EXIST_MSG = "%s is taken";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));

        return user.map(MyUserDetails::new).get();
    }

    public String signUpUser(User user) {
        String encodedPassword;
        String token;
        ConfirmationToken confirmationToken;
        boolean usernameExists = userRepository
                .findByUsername(user.getUsername())
                .isPresent();
        boolean emailExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (usernameExists || emailExists) {
            throw new IllegalStateException(emailExists ? String.format(EXIST_MSG, user.getEmail())
                    : String.format(EXIST_MSG, user.getUsername()) );
        }
        encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        token = UUID.randomUUID().toString();
        confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO: Send email

        return token;
    }

    public int activateUser(String email) {
        return userRepository.activateUser(email);
    }
}
