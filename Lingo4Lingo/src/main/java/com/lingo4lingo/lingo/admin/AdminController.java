package com.lingo4lingo.lingo.admin;

import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/admin")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    private Optional<User> getUserById(@PathVariable(value = "id") Long id) {
        return adminService.getUserById(id);
    }

    @DeleteMapping("/users/delete/{id}")
    private Long deleteUser(@PathVariable(value = "id") Long id) {
        adminService.deleteById(id);
        return id;
    }
}
