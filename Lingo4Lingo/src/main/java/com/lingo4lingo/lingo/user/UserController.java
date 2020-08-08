package com.lingo4lingo.lingo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user/loggedIn")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update/{id}")
    public Long updateUserById(@PathVariable(value = "id") Long id, @RequestBody User user) {
        userService.updateUserById(id, user);
        return id;
    }
}
