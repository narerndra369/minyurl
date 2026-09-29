package com.minyurl.generate.service;

import com.minyurl.generate.dto.RequestDto;
import com.minyurl.generate.model.UrlMapping;
import com.minyurl.generate.repository.UrlMappingRepo;
import com.minyurl.generate.service.shortcode.EncodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortCodeService {
    @Autowired
    EncodeService encodeService;

    @Autowired
    UrlMappingRepo urlMappingRepo;
    public String generateShortUrl(RequestDto requestDto) {
        Optional<UrlMapping> optionalUrlMapping;
        optionalUrlMapping = urlMappingRepo.findByLongUrl(requestDto.getLongUrl());
        if(optionalUrlMapping.isPresent()){
            return optionalUrlMapping.get().getShortCode();
        }
        String shortCode;
        do{
            shortCode = encodeService.createShortCode();
            optionalUrlMapping = urlMappingRepo.findByShortCode(shortCode);
        }while(optionalUrlMapping.isPresent());

        UrlMapping urlMapping = new UrlMapping();

        urlMapping.setShortCode(shortCode);
        urlMapping.setLongUrl(requestDto.getLongUrl());
        if(requestDto.getExpireAt() != null)    urlMapping.setExpireAt(requestDto.getExpireAt());

        urlMappingRepo.save(urlMapping);

        return shortCode;
    }

    public boolean generateShortUrlCustom(RequestDto requestDto){
        String longUrl = requestDto.getLongUrl();
        String shortUrl = requestDto.getCustom();
        Optional<UrlMapping>  optionalUrlMapping= urlMappingRepo.findByShortCode(shortUrl);
        if(optionalUrlMapping.isPresent()){
            return false;
        }

        UrlMapping urlMapping = new UrlMapping();

        urlMapping.setShortCode(requestDto.getCustom());
        urlMapping.setLongUrl(requestDto.getLongUrl());
        if(requestDto.getExpireAt() != null)    urlMapping.setExpireAt(requestDto.getExpireAt());

        urlMappingRepo.save(urlMapping);

        return true;
    }
}
