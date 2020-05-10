package com.lingo4lingo.lingo.userManagement;

import com.lingo4lingo.lingo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementDtoJpa extends JpaRepository<User, Long> {
}
