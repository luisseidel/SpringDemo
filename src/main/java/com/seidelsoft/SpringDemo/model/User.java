package com.seidelsoft.SpringDemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable, GenericEntity<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Override
    public void update(User source) {
        this.email = source.getEmail();
        this.password = source.getPassword();
        this.name = source.getName();
        this.role = source.getRole();
    }

    @Override
    public Long getId() {
        return this.getId();
    }

    @Override
    public User createNewInstance() {
        User newInstance = new User();
        newInstance.update(this);

        return newInstance;
    }
}
