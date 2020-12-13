package com.lingo4lingo.lingo.security.securityControllers;

import com.lingo4lingo.lingo.security.securityAuth.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReactAuthenticationController {

    @GetMapping(path = "/reactAuth")
    public AuthenticationBean welcomeToBasicAuth() {
        // throw new RuntimeException("Authentication Error!");
        return new AuthenticationBean("Welcome to Lingo4Lingo (BasicAuth), you are authenticated");
    }

    @GetMapping(path = "/login")
    public AuthenticationBean welcomeToFormBasedAuth() {
        return new AuthenticationBean("Welcome to Lingo4Lingo (FormBasedAuth), you are authenticated");
    }

    @PostMapping(path = "/login")
    public AuthenticationBean welcomeToFormBasedAuth2() {
        return new AuthenticationBean("Welcome to Lingo4Lingo (FormBasedAuth2), you are authenticated");
    }
}
