package com.lingo4lingo.lingo.user;

import com.lingo4lingo.lingo.dao.UserDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    final private UserDaoJdbc UserDaoJdbc;
    final private UserDaoJpa userDaoJpa;

    @Autowired
    public UserService(UserDaoJdbc UserDaoJdbc, UserDaoJpa userDaoJpa) {
        this.UserDaoJdbc = UserDaoJdbc;
        this.userDaoJpa = userDaoJpa;
    }

    void updateUserById(Long id, User user) {
        if (userDaoJpa.existsById(id)) {
            userDaoJpa.save(user);
            System.out.println("The user with the id: " + id + " has been updated!");
        } else {
            System.out.println("The id: " + id + " doesn't exist!");
        }
    }

//    Long updateUserById(Long id, User user) {
//
//        Optional.ofNullable(user.getEmail())
//                .ifPresent(email -> {
//                    boolean taken = UserRepository.selectExistEmail(id, email);
//                    if ((!taken)) {
//                        UserRepository.updateEmail(id, email);
//                    } else {
//                        throw new IllegalStateException("Email already in use:" + user.getEmail());
//                    }
//                });
//
//        Optional.ofNullable(user.getLogin())
//                .filter(login -> !StringUtils.isEmpty(login))
//                .map(StringUtils::capitalize)
//                .ifPresent(login -> UserRepository.updateLogin(id, login));
//
//        Optional.ofNullable(user.getGender())
//                .filter(gender -> !StringUtils.isEmpty(gender))
//                .map((User.Gender str) -> StringUtils.capitalize(String.valueOf(str)))
//                .ifPresent((String gender) -> {
//                    UserRepository.updateGender(id, gender);
//                });
//
//        Optional.ofNullable(user.getCity())
//                .filter(city -> !StringUtils.isEmpty(city))
//                .map(StringUtils::capitalize)
//                .ifPresent(city -> UserRepository.updateCity(id, city));
//
//        Optional.ofNullable(user.getCountry())
//                .filter(country -> !StringUtils.isEmpty(country))
//                .map(StringUtils::capitalize)
//                .ifPresent(country -> UserRepository.updateCountry(id, country));
//
//        Optional.ofNullable(user.getRegionProvince())
//                .filter(regionProvince -> !StringUtils.isEmpty(regionProvince))
//                .map(StringUtils::capitalize)
//                .ifPresent(regionProvince -> UserRepository.updateRegion(id, regionProvince));
//
//        Optional.ofNullable(user.getLanguageNative1())
//                .filter(languageNative1 -> !StringUtils.isEmpty(languageNative1))
//                .map(StringUtils::capitalize)
//                .ifPresent(languageNative1 -> UserRepository.updateLanguageNative1(id, languageNative1));
//        return id;
//    }
}
