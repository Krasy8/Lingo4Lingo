package com.lingo4lingo.lingo.user.loggedIn.userSearch;

import com.lingo4lingo.lingo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSearchDtoJpa extends JpaRepository<User, Long> {
}
