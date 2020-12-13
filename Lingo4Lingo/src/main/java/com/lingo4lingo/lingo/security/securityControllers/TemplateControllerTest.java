package com.lingo4lingo.lingo.security.securityControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class TemplateControllerTest {

    @GetMapping("welcome")
    public String getWelcomePage() {
        return "Welcome to lingo 4 lingo!";
    }
}
