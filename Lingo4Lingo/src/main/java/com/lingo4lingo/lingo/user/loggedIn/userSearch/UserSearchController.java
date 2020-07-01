package com.lingo4lingo.lingo.user.loggedIn.userSearch;

import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/loggedIn/search")
@CrossOrigin(origins = "http://localhost:3000")
public class UserSearchController {

    final UserSearchService userSearchService;

    @Autowired
    public UserSearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping("/{city}-{language}")
    public List<User> getUserByLanguageAndCity(@PathVariable String city, @PathVariable String language) {
        return userSearchService.getUserByLanguageAndCity(city, language);
    }

    @GetMapping("/city/{city}")
    public List<User> getUserByCity(@PathVariable String city) {
        return userSearchService.getUserByCity(city);
    }

    @GetMapping("/language/{language}")
    public List<User> getUserByLanguage(@PathVariable String language) {
        return userSearchService.getUserByLanguage(language);
    }
    @GetMapping("/native/{nativeLanguage}")
    public List<User> getUserByNativeLanguage (@PathVariable String nativeLanguage){
        return userSearchService.getUserByNativeLanguage(nativeLanguage);
    }
    @GetMapping("/native-loc/{city}-{nativeLanguage}")
    public List<User> getUserByNativeLanguage (@PathVariable String city, @PathVariable String nativeLanguage){
        return userSearchService.getUserByNativeLanguageAndCity(city, nativeLanguage);
    }
}
