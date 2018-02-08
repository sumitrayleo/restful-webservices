package com.tutorial.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tutorial.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<CommonError> handleUserNotFoundException(final UserNotFoundException exception){
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        CommonError error = new CommonError(HttpStatus.NOT_FOUND.toString(), new Date(), exception.getMessage());
        return new ResponseEntity<CommonError>(error, headers, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ResponseEntity<CommonError> handleDefaultException(final Exception exception){
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        CommonError error = new CommonError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), new Date(), exception.getMessage());
        return new ResponseEntity<CommonError>(error, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
