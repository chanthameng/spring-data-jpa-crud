package com.kshrd.springdatajpacrud.repository;

import com.kshrd.springdatajpacrud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
