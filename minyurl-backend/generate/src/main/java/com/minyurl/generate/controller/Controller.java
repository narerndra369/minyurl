package com.minyurl.generate.controller;

import com.minyurl.generate.dto.ErrorResponseDto;
import com.minyurl.generate.dto.RequestDto;
import com.minyurl.generate.dto.ResponseDto;
import com.minyurl.generate.service.ShortCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    ShortCodeService shortCodeService;

    @PostMapping("/shortcode")
    private ResponseEntity<Object> generateShortUrl(@RequestBody RequestDto requestDto){
        String shortCode = "http://localhost:9000/";
        if(requestDto.getCustom() != null){
            if(shortCodeService.generateShortUrlCustom(requestDto)){
                shortCode += requestDto.getCustom();
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto("Alias already exists try with another custom name."));
            }
        }else {
            shortCode += shortCodeService.generateShortUrl(requestDto);
        }
        return ResponseEntity.status(201).body(new ResponseDto(shortCode));
    }
}
