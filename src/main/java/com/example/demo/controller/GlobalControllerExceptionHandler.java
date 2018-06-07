package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ InternalAuthenticationServiceException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "BadCredentialsException Message Here", new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

}
