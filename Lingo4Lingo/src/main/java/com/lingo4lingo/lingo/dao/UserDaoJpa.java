package com.lingo4lingo.lingo.dao;

import com.lingo4lingo.lingo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoJpa extends JpaRepository<User, Long> {

    User findByLogin(String login);

    User findByEmail(String email);

    @Override
    void delete(User user);
}
