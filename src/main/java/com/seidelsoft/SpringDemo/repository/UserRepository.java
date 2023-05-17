package com.seidelsoft.SpringDemo.repository;

import com.seidelsoft.SpringDemo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends GenericRepository<User>{

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);

}
