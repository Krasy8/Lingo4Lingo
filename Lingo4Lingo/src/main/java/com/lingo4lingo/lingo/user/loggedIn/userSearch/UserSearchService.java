package com.lingo4lingo.lingo.user.loggedIn.userSearch;

import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    final private UserSearchDtoJdbc userSearchDtoJdbc;

    @Autowired
    public UserSearchService(UserSearchDtoJdbc userSearchDtoJdbc) {
        this.userSearchDtoJdbc = userSearchDtoJdbc;
    }

    List<User> getUserByCity(String city) {
        return userSearchDtoJdbc.getUserByCity(city);
    }

    List<User> getUserByLanguage(String language) {
        return userSearchDtoJdbc.getUserBySpokenLanguage(language);
    }

    List<User> getUserByNativeLanguage (String language) {
        return userSearchDtoJdbc.getUserByNativeLanguage(language);

    }

    List<User> getUserByLanguageAndCity(String city, String language) {
        return userSearchDtoJdbc.getUserByLanguageAndCity(city, language);
    }
    List<User> getUserByNativeLanguageAndCity (String city, String language) {
        return userSearchDtoJdbc.getUserByNativeLanguageAndCity(city, language);
    }
}
