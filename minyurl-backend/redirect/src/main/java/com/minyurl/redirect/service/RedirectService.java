package com.minyurl.redirect.service;

import com.minyurl.redirect.exception.UrlNotFoundException;
import com.minyurl.redirect.model.UrlMapping;
import com.minyurl.redirect.repository.UrlMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    @Autowired
    UrlMappingRepo urlMappingRepo;

    @Cacheable(value = "minyUrl", key = "#shortCode")
    public String  redirectHandling(String shortCode) {
        Optional<UrlMapping> urlMappingOptional = urlMappingRepo.findByShortCode(shortCode);

        if(!urlMappingOptional.isPresent()){
            throw new UrlNotFoundException("Url not found please genrate a short url");
        }

        return urlMappingOptional.get().getLongUrl();
    }
}
