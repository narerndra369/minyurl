package com.minyurl.redirect.controller;

import com.minyurl.redirect.service.RedirectService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RedirectController {

    @Autowired
    RedirectService redirectService;

    @GetMapping("/{shortCode}")
    public ResponseEntity<Object> redirectHandling(@PathVariable String shortCode){
        String longUrl = redirectService.redirectHandling(shortCode);
        return ResponseEntity.status(302).location(URI.create(longUrl)).build();
    }
}
