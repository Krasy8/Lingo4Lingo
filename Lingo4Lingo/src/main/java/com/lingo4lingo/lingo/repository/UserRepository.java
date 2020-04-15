package com.lingo4lingo.lingo.repository;

import com.lingo4lingo.lingo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID id);

    void deleteById(UUID id);
    // User findByConfirmationToken(String confirmationToken);
}
