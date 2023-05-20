package com.seidelsoft.SpringDemo.repository;

import com.seidelsoft.SpringDemo.model.entity.Role;

public interface RoleRepository extends GenericRepository<Role>{

    Role findByName(String name);

}
