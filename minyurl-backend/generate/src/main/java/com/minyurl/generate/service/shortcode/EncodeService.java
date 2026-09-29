package com.minyurl.generate.service.shortcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncodeService {
    @Autowired
    IdGenerator idGenerator;

    public String createShortCode(){
        long unique = idGenerator.nextId();
        String shortCode = BASE62.encode(unique);
        while(shortCode.length() < 7){
            shortCode = "0"+shortCode;
        }

        return shortCode.substring(0,7);
    }
}
