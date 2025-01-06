package com.kshrd.springdatajpacrud.service.role;

import com.kshrd.springdatajpacrud.dto.request.RoleRequest;
import com.kshrd.springdatajpacrud.entity.Role;

public interface RoleService {
    public Role createRole(RoleRequest role);
    public Role deleteRole(Integer role);
}
