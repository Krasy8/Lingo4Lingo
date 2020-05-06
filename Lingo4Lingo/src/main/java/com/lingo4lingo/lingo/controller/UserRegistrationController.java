package com.lingo4lingo.lingo.controller;

import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/countries")
    public List<String> getAllCountries() {
        return userRegistrationService.getAllCountries();
    }

    @GetMapping("/cities/{country}")
    public List<String> getCitiesByCountry(@PathVariable(value = "country") String country) {
        return userRegistrationService.getCitiesByCountry(country);
    }

    @GetMapping("/languages")
    public List<String> getUniqueLanguages() {
        return userRegistrationService.getUniqueLanguages();
    }

    @PostMapping("/userRegistration")
    public void addNewUser(@RequestBody @Valid User user) {
        userRegistrationService.addNewUser(user);
    }

    @GetMapping("/isEmailTaken/{email}")
    public boolean isEmailTaken(@PathVariable(value = "email") String email) {
        return userRegistrationService.isEmailTaken(email);
    }
}
