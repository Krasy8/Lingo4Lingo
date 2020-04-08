package com.lingo4lingo.lingo.controller;

import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private User getUserById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable(value = "id") Long id) {
        userService.delete(id);
    }

    @PostMapping("/user")
    private long saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getId();
    }

//    Wykomentowalem ponizsze bo mi Spring nie mogl zmapowac dwoch takich samych metod (POST)
//    na ten sam URL. Nie wiem do konca, dlaczego Kuba zrobil dwie jakby duplikujace sie.

//    @PostMapping("/user")
//    private User update(@RequestBody User user) {
//        userService.saveOrUpdate(user);
//        return user;
//    }
}
