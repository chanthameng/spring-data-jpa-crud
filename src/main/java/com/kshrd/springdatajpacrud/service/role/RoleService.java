package com.kshrd.springdatajpacrud.service.role;

import com.kshrd.springdatajpacrud.entity.Role;

public interface RoleService {
    public Role createRole(String role);
    public Role deleteRole(Integer role);
}
