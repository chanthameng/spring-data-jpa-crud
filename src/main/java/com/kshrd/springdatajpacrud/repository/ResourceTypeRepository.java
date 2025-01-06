package com.kshrd.springdatajpacrud.repository;

import com.kshrd.springdatajpacrud.entity.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface ResourceTypeRepository extends JpaRepository<ResourceType, Integer> {
}
