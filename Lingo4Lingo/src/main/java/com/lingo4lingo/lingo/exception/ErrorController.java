package com.lingo4lingo.lingo.exception;

import com.lingo4lingo.lingo.exception.ErrorControllerInterface;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController implements ErrorControllerInterface {

    private static final String ERROR_MAPPING = "/error";

//    @RequestMapping(value = ERROR_MAPPING)
//    public ResponseEntity<String> error() {
//        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//    }

    @Override
    public String getErrorPath() {
        return ERROR_MAPPING;
    }
}
