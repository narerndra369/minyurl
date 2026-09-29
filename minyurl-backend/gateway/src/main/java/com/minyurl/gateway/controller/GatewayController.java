package com.minyurl.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/contactSupport")
    public ResponseEntity<Object> fallBack(){
        return ResponseEntity.status(500).body("Mail issues to the Contact Support : usemeon1@gmail.com");
    }
}
