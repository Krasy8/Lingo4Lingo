package com.lingo4lingo.lingo.service;

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
}
