package com.seidelsoft.SpringDemo.service;

import com.seidelsoft.SpringDemo.model.dto.UserDTO;
import com.seidelsoft.SpringDemo.model.entity.Role;
import com.seidelsoft.SpringDemo.model.entity.User;
import com.seidelsoft.SpringDemo.repository.RoleRepository;
import com.seidelsoft.SpringDemo.repository.UserRepository;
import com.seidelsoft.SpringDemo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDTO dto) {
        Role role = roleRepository.findByName(Constants.Roles.USER);
        if (role == null) {
            role = roleRepository.save(new Role(Constants.Roles.USER));
        }

        User user = new User(dto.getEmail(), passwordEncoder.encode(dto.getPassword()), dto.getName(), Arrays.asList(role));
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
