package com.codestates.stackoverflow.user.repository;

import com.codestates.stackoverflow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByUserId(Long userId);
}
