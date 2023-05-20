package com.seidelsoft.SpringDemo.repository;

import com.seidelsoft.SpringDemo.model.entity.User;

public interface UserRepository extends GenericRepository<User>{

    //@Query("SELECT u FROM User u WHERE u.email = :email")
    //User findUserByEmail(@Param("email") String email);

    User findByEmail(String email);

}
