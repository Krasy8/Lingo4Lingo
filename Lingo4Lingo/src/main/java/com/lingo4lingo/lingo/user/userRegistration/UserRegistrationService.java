package com.lingo4lingo.lingo.user.userRegistration;

import com.lingo4lingo.lingo.exception.ApiRequestException;
import com.lingo4lingo.lingo.security.securityDao.RoleDaoJpa;
import com.lingo4lingo.lingo.user.User;
import com.lingo4lingo.lingo.dao.UserDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRegistrationService {

    private final UserRegistrationDaoJdbc userRegistrationDaoJdbc;
    private final UserDaoJpa userDaoJpa;
    private final PasswordEncoder passwordEncoder;
    private final RoleDaoJpa roleDaoJpa;

    @Autowired
    public UserRegistrationService(
            UserRegistrationDaoJdbc userRegistrationDaoJdbc,
            UserDaoJpa userDaoJpa,
            PasswordEncoder passwordEncoder,
            RoleDaoJpa roleDaoJpa) {
        this.userRegistrationDaoJdbc = userRegistrationDaoJdbc;
        this.userDaoJpa = userDaoJpa;
        this.passwordEncoder = passwordEncoder;
        this.roleDaoJpa = roleDaoJpa;
    }

    List<String> getAllCountries() {
        return userRegistrationDaoJdbc.selectAllCountries();
    }

    List<String> getCitiesByCountry(String country) {
        return userRegistrationDaoJdbc.selectCitiesByCountry(country);
    }

    List<String> getUniqueLanguages() {
        return userRegistrationDaoJdbc.selectUniqueLanguages();
    }

    void registerNewUser(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDaoJdbc.isEmailTaken(userRegistrationDto.getEmail())) {
            throw new ApiRequestException(userRegistrationDto.getEmail() + " is already taken by another user");
        }

        User newUser = new User();

        newUser.setLogin(userRegistrationDto.getLogin());
        newUser.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        newUser.setEmail(userRegistrationDto.getEmail());
        newUser.setGender(User.Gender.valueOf(userRegistrationDto.getGender()));
        newUser.setDateOfBirth(userRegistrationDto.getDateOfBirth());
        newUser.setCountryOfResidence(userRegistrationDto.getCountryOfResidence());
        newUser.setCityOfResidence(userRegistrationDto.getCityOfResidence());
        newUser.setRegionProvince(userRegistrationDto.getRegionProvince());
        newUser.setLanguageNative1(userRegistrationDto.getLanguageNative1());
        newUser.setLanguageNative2(userRegistrationDto.getLanguageNative2());
        newUser.setLanguageNative3(userRegistrationDto.getLanguageNative3());
        newUser.setLanguageSpoken1(userRegistrationDto.getLanguageSpoken1());
        newUser.setLanguageSpoken2(userRegistrationDto.getLanguageSpoken2());
        newUser.setLanguageSpoken3(userRegistrationDto.getLanguageSpoken3());
        newUser.setLanguageSpoken4(userRegistrationDto.getLanguageSpoken4());
        newUser.setLanguageSpoken5(userRegistrationDto.getLanguageSpoken5());
        newUser.setLanguageToLearn(userRegistrationDto.getLanguageToLearn());
        newUser.setSelfDescription(userRegistrationDto.getSelfDescription());

        newUser.setRoles(Arrays.asList(roleDaoJpa.findRoleByName("ROLE_USER")));
        newUser.setEnabled(true);
        newUser.setTokenExpired(false);

        userDaoJpa.save(newUser);
    }

    boolean isEmailTaken(String email) {
        return userRegistrationDaoJdbc.isEmailTaken(email);
    }
}
