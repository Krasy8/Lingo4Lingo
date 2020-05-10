package com.lingo4lingo.lingo.user.registration;

import com.lingo4lingo.lingo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationDtoJpa extends JpaRepository<User, Long> {
}
