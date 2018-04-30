package com.pagepots.repository;

import com.pagepots.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);

    User findByEmail(String email);
}
