package com.kshrd.springdatajpacrud.service.role;

import com.kshrd.springdatajpacrud.entity.Role;
import com.kshrd.springdatajpacrud.repository.RoleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String role) {
        Role roleEntity = new Role();
        roleEntity.setRoleName(role);

        return roleRepository.save(roleEntity);
    }
}
