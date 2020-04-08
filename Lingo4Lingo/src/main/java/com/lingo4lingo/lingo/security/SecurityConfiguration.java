package com.lingo4lingo.lingo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/confirm").permitAll();

        // dodalem ponizsze, aby przetestowac POST request w Postmanie, bo krzyczal
        // mi blad 403 Forbidden. Ogolnie to obniza zabezpieczenia aplikacji i
        // na pewno ustawimy to inaczej.
        http.csrf().disable();
    }
}
