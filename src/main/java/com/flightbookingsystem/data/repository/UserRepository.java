package com.flightbookingsystem.data.repository;

import com.flightbookingsystem.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

}
