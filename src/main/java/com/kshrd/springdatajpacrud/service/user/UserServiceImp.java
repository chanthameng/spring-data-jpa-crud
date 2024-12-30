package com.kshrd.springdatajpacrud.service.user;

import com.kshrd.springdatajpacrud.dto.request.UserRequest;
import com.kshrd.springdatajpacrud.entity.Role;
import com.kshrd.springdatajpacrud.entity.User;
import com.kshrd.springdatajpacrud.exception.specificException.NotFoundException;
import com.kshrd.springdatajpacrud.repository.RoleRepository;
import com.kshrd.springdatajpacrud.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    //Inject the repo bean
    public UserServiceImp(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User saveUser(UserRequest userRequest) {
        Role roleDb = roleRepository.findById(userRequest.getRole())
                .orElseThrow(() -> new NotFoundException("Role not found"));

        Role role = new Role();
        role.setRoleId(roleDb.getRoleId());
        role.setRoleName(roleDb.getRoleName());

      /*
      When working with a request object (UserRequest) and needing to save data to the repository, you must convert the request DTO (Data Transfer Object)
      into the entity type (User). This is because the repository operates on entity objects managed by JPA/Hibernate. Below is a guide to handle this properly:
       */

        User user = new User();
        user.setFullName(userRequest.getFullName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(role);



        return userRepository.save(user);
    }
}
