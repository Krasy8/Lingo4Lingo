package com.lingo4lingo.lingo.userManagement;

import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {

    public final UserManagementDtoJdbc userManagementDtoJdbc;
    public final UserManagementDtoJpa userManagementDtoJpa;

    @Autowired
    public UserManagementService(UserManagementDtoJdbc userManagementDtoJdbc, UserManagementDtoJpa userManagementDtoJpa) {
        this.userManagementDtoJdbc = userManagementDtoJdbc;
        this.userManagementDtoJpa = userManagementDtoJpa;
    }

    List<User> getAllUsers() {
//        return userManagementDtoJdbc.selectAllUsers();
        return userManagementDtoJpa.findAll();
    }

    Optional<User> getUserById(Long id) {
//        return userManagementDtoJdbc.getUserById(id);
        return userManagementDtoJpa.findById(id);
    }

    void deleteById(Long id) {
//        userManagementDtoJdbc.deleteById(id);
        userManagementDtoJpa.deleteById(id);
        System.out.println("The user with the id: " + id + " has been deleted!");
    }
}
