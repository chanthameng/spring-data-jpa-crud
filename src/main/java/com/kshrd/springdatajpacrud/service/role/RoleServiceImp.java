package com.kshrd.springdatajpacrud.service.role;

import com.kshrd.springdatajpacrud.dto.request.RoleRequest;
import com.kshrd.springdatajpacrud.entity.Role;
import com.kshrd.springdatajpacrud.entity.User;
import com.kshrd.springdatajpacrud.exception.specificException.NotFoundException;
import com.kshrd.springdatajpacrud.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(RoleRequest role) {
        Role roleEntity = new Role();
        roleEntity.setRoleName(role.getRole());

        return roleRepository.save(roleEntity);
    }

    @Override
    public Role deleteRole(Integer roleID) {
        Optional<Role> role = roleRepository.findById(roleID);
        if (role.isPresent()) {

            Role roleEntity = role.get();
            roleRepository.delete(roleEntity);

            return roleEntity;
        } else {
            throw
                    new NotFoundException("Role not found");
        }

    }

}
