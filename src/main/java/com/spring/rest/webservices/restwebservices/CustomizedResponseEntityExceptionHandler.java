package com.spring.rest.webservices.restwebservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//Must be applicable across all the controllers
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Study this
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity handleAllExceptions(Exception ex, WebRequest request) throws Exception {
//
//        ExceptionResponse exceptionResponse =
//                new ExceptionResponse(
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
//
//        ExceptionResponse exceptionResponse =
//                new ExceptionResponse(
//                        new Date(),
//                        ex.getMessage(),
//                        request.getDescription(false));
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
}
