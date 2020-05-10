package com.lingo4lingo.lingo.userManagement;

import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/userManagement")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserManagementController {

    final UserManagementService userManagementService;

    @Autowired
    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return userManagementService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    private Optional<User> getUserById(@PathVariable(value = "id") Long id) {
        return userManagementService.getUserById(id);
    }

    @DeleteMapping("/users/delete/{id}")
    private Long deleteUser(@PathVariable(value = "id") Long id) {
        userManagementService.deleteById(id);
        return id;
    }
}
