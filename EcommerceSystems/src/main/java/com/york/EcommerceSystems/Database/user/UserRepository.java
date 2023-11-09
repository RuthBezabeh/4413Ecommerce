package com.york.EcommerceSystems.Database.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
