package com.enigmacamp.enigmacoop.repository;

import com.enigmacamp.enigmacoop.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,String> {
    Optional<UserCredential> findByUsername(String username);
}