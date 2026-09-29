package com.minyurl.generate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class RequestDto {
    private String longUrl;
    private LocalDateTime expireAt;
    private String custom;
}
