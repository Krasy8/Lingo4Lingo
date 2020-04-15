package com.lingo4lingo.lingo.controller;

import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private Optional<User> getUserById(@PathVariable(value = "id") UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    private UUID deleteUser(@PathVariable(value = "id") UUID id) {
        userService.delete(id);
        return id;
    }

    @PostMapping("/user")
    private UUID saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getId();
    }

    @PutMapping("/user/{id}")
    private UUID updateUser(@PathVariable(value = "id") UUID id, @RequestBody User user) {
        userService.update(user, id);
        return id;
    }
}
