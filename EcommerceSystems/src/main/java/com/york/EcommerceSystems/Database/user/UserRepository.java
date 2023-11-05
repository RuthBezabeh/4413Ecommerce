package com.york.EcommerceSystems.Database.user;

import com.york.EcommerceSystems.Database.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
