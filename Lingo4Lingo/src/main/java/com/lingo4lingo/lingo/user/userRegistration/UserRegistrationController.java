package com.lingo4lingo.lingo.user.userRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user/registration")
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

    @PostMapping("/newUser")
    public void addNewUser(@RequestBody @Valid UserRegistrationDto user) {
        userRegistrationService.registerNewUser(user);
    }

    @GetMapping("/isEmailTaken/{email}")
    public boolean isEmailTaken(@PathVariable(value = "email") String email) {
        return userRegistrationService.isEmailTaken(email);
    }
}
