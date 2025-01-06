package com.kshrd.springdatajpacrud.repository;

import com.kshrd.springdatajpacrud.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}
