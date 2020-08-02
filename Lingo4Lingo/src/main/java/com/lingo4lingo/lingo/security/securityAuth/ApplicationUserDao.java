package com.lingo4lingo.lingo.security.securityAuth;

public interface ApplicationUserDao {

    ApplicationUser selectApplicationUserByLogin(String login);
}
