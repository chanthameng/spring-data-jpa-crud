package com.kshrd.springdatajpacrud.service.user;

import com.kshrd.springdatajpacrud.dto.request.UserRequest;
import com.kshrd.springdatajpacrud.entity.User;

public interface UserService {
public User saveUser(UserRequest user);
}
