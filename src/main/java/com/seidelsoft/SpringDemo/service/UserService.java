package com.seidelsoft.SpringDemo.service;

import com.seidelsoft.SpringDemo.model.dto.UserDTO;
import com.seidelsoft.SpringDemo.model.entity.User;

public interface UserService {

    void saveUser(UserDTO dto);
    User findUserByEmail(String email);
}
