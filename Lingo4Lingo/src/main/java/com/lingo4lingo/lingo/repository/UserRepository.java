package com.lingo4lingo.lingo.repository;

import com.lingo4lingo.lingo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findById(Long id);

    User deleteById(Long id);
    // User findByConfirmationToken(String confirmationToken);
}
