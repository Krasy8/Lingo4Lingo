package com.lingo4lingo.lingo.user.loggedIn;

import com.lingo4lingo.lingo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDtoJpa extends JpaRepository<User, Long> {

}
