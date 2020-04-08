package com.lingo4lingo.lingo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController implements ErrorControllerInterface {

    private static final String ERROR_MAPPING = "/error";

//    Wykomentowalem ponizsze bo Spring krzyczal,
//    ze ma dwie metody probujace zrobic to samo...

//    @RequestMapping(value = ERROR_MAPPING)
//    public ResponseEntity<String> error() {
//        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//    }

    @Override
    public String getErrorPath() {
        return ERROR_MAPPING;
    }
}
