package com.minyurl.redirect.exception;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class ExceptionHandler {

    @Value("${error.longUrl}")
    private String errorLongUrl;

    @org.springframework.web.bind.annotation.ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<Void> urlNotFoundExceptionHandler(){
        return ResponseEntity.status(302).location(URI.create(errorLongUrl)).build();
    }
}
