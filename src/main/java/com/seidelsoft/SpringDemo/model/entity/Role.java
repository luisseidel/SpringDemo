package com.seidelsoft.SpringDemo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GenericEntity<Role> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }

    @Override
    public void update(Role source) {
        this.name = source.getName();
        this.users = source.getUsers();
    }

    @Override
    public Role createNewInstance() {
        Role newInstance = new Role();
        newInstance.update(this);

        return newInstance;
    }
}
