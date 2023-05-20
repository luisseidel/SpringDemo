package com.seidelsoft.SpringDemo.controller;

import com.seidelsoft.SpringDemo.model.dto.LoginDTO;
import com.seidelsoft.SpringDemo.model.entity.User;
import com.seidelsoft.SpringDemo.service.UserService;
import com.seidelsoft.SpringDemo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/loadUser")
    public UserDetails loadUserByUsername(@RequestBody LoginDTO loginDTO) throws UsernameNotFoundException {
        System.out.println("EMail: " + loginDTO.getEmail());
        User user = service.findUserByEmail(loginDTO.getEmail());
        System.out.println(user.toString());
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles(Constants.Roles.USER)
                        .build();

        return userDetails;
    }
}
