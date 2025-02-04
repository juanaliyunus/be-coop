package com.enigmacamp.enigmacoop.repository;

import com.enigmacamp.enigmacoop.constant.ERole;
import com.enigmacamp.enigmacoop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,String> {

    Optional<Role> findByRole(ERole role);
}
