package com.lingo4lingo.lingo.repository;

import com.lingo4lingo.lingo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(Long id);

    void deleteById(Long id);
    // User findByConfirmationToken(String confirmationToken);
}
