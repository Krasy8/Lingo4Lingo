package com.lingo4lingo.lingo.service;

import com.lingo4lingo.lingo.exception.ApiRequestException;
import com.lingo4lingo.lingo.model.entity.User;
import com.lingo4lingo.lingo.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;

    @Autowired
    public UserRegistrationService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    public List<String> getAllCountries() {
        return userRegistrationRepository.selectAllCountries();
    }

    public List<String> getCitiesByCountry(String country) {
        return userRegistrationRepository.selectCitiesByCountry(country);
    }

    public List<String> getUniqueLanguages() {
        return userRegistrationRepository.selectUniqueLanguages();
    }

    public void addNewUser(User user) {
        if (userRegistrationRepository.isEmailTaken(user.getEmail())) {
            throw new ApiRequestException(user.getEmail() + " is already taken by another user");
        }
        userRegistrationRepository.insertUser(user);
    }

    public boolean isEmailTaken(String email) {
        return userRegistrationRepository.isEmailTaken(email);
    }
}
