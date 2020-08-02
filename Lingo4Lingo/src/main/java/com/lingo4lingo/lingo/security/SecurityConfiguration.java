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
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/v1/user/registration/**").permitAll()
                .antMatchers("/api/v1/admin/**").hasAnyAuthority("ADMIN_READ", "ADMIN_WRITE")
                .antMatchers("/api/v1/components/userSearch/**").hasAnyAuthority("USER_READ", "USER_WRITE")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .permitAll()
                    .defaultSuccessUrl("/welcome", true)
                    .passwordParameter("password")
                    .usernameParameter("login");
    }
}
