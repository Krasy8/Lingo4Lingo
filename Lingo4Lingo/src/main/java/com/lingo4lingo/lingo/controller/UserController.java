package com.lingo4lingo.lingo.controller;

import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private Optional<User> getUserById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    private Long deleteUser(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return id;
    }

    @PostMapping("/user")
    private Long saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getId();
    }

    @PutMapping("/user/{id}")
    private Long updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        userService.update(user, id);
        return id;
    }
}
