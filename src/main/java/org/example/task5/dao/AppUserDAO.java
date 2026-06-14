package org.example.task5.dao;

import org.example.task5.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserDAO extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findAppUserByEmail(String email);
}
