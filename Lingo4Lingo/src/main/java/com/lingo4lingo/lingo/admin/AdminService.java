package com.lingo4lingo.lingo.admin;

import com.lingo4lingo.lingo.user.User;
import com.lingo4lingo.lingo.dao.UserDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    public final AdminDaoJdbc adminDaoJdbc;
    public final UserDaoJpa userDaoJpa;

    @Autowired
    public AdminService(AdminDaoJdbc adminDaoJdbc, UserDaoJpa userDaoJpa) {
        this.adminDaoJdbc = adminDaoJdbc;
        this.userDaoJpa = userDaoJpa;
    }

    List<User> getAllUsers() {
//        return adminDaoJdbc.selectAllUsers();
        return userDaoJpa.findAll();
    }

    Optional<User> getUserById(Long id) {
//        return adminDaoJdbc.getUserById(id);
        return userDaoJpa.findById(id);
    }

    void deleteById(Long id) {
//        adminDaoJdbc.deleteById(id);
        userDaoJpa.deleteById(id);
        System.out.println("The user with the id: " + id + " has been deleted!");
    }
}
