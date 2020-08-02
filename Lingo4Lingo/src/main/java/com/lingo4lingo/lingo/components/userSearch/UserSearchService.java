package com.lingo4lingo.lingo.components.userSearch;

import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    final private UserSearchDaoJdbc userSearchDaoJdbc;

    @Autowired
    public UserSearchService(UserSearchDaoJdbc userSearchDaoJdbc) {
        this.userSearchDaoJdbc = userSearchDaoJdbc;
    }

    List<User> getUserByCity(String city) {
        return userSearchDaoJdbc.getUserByCity(city);
    }

    List<User> getUserByLanguage(String language) {
        return userSearchDaoJdbc.getUserBySpokenLanguage(language);
    }

    List<User> getUserByNativeLanguage (String language) {
        return userSearchDaoJdbc.getUserByNativeLanguage(language);

    }

    List<User> getUserByLanguageAndCity(String city, String language) {
        return userSearchDaoJdbc.getUserByLanguageAndCity(city, language);
    }
    List<User> getUserByNativeLanguageAndCity (String city, String language) {
        return userSearchDaoJdbc.getUserByNativeLanguageAndCity(city, language);
    }
}
