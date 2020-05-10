package com.lingo4lingo.lingo.user.registration;

import com.lingo4lingo.lingo.exception.ApiRequestException;
import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationService {

    private final UserRegistrationDtoJdbc userRegistrationDtoJdbc;
    private final UserRegistrationDtoJpa userRegistrationDtoJpa;

    @Autowired
    public UserRegistrationService(UserRegistrationDtoJdbc userRegistrationDtoJdbc, UserRegistrationDtoJpa userRegistrationDtoJpa) {
        this.userRegistrationDtoJdbc = userRegistrationDtoJdbc;
        this.userRegistrationDtoJpa = userRegistrationDtoJpa;
    }

    List<String> getAllCountries() {
        return userRegistrationDtoJdbc.selectAllCountries();
    }

    List<String> getCitiesByCountry(String country) {
        return userRegistrationDtoJdbc.selectCitiesByCountry(country);
    }

    List<String> getUniqueLanguages() {
        return userRegistrationDtoJdbc.selectUniqueLanguages();
    }

    void addNewUser(User user) {
        if (userRegistrationDtoJdbc.isEmailTaken(user.getEmail())) {
            throw new ApiRequestException(user.getEmail() + " is already taken by another user");
        }
//        userRegistrationDtoJdbcTemplate.insertUser(user);
        userRegistrationDtoJpa.save(user);
    }

    boolean isEmailTaken(String email) {
        return userRegistrationDtoJdbc.isEmailTaken(email);
    }
}
