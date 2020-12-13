package com.lingo4lingo.lingo.security.securityAuth;

public class AuthenticationBean {

    private String message;

    public AuthenticationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("WelcomeToReactBean [message=%s]", message);
    }
}
