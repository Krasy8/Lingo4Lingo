package com.lingo4lingo.lingo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
 class UserNotFoundException extends RuntimeException {

   // private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
