package com.lingo4lingo.lingo.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TemplateControllerTest {

    @GetMapping("welcome")
    public String getWelcomePage() {
        return "Welcome to lingo 4 lingo!";
    }
}
