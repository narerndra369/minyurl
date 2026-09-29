package com.minyurl.redirect.exception;

public class UrlNotFoundException extends RuntimeException{
    public UrlNotFoundException(String msg){
        super(msg);
    }
}
