package com.springboot.project.gestionedu.core.dao.repositories;

import com.springboot.project.gestionedu.core.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
