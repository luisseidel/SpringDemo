package com.seidelsoft.SpringDemo.controller;

import com.seidelsoft.SpringDemo.model.User;
import com.seidelsoft.SpringDemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<User> {

    private UserRepository repository;
    public UserController(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findUserByEmail(email);
        List<String> roles = Arrays.asList(user.getRole());
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles("USER")
                        .build();

        return userDetails;
    }
}
