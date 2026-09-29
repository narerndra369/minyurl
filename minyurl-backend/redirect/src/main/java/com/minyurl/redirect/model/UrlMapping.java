package com.minyurl.redirect.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "url_mapping")
@Getter @Setter @NoArgsConstructor
public class UrlMapping {
    @Id
    @Column(name = "short_code", length = 10, nullable = false)
    private String shortCode;
    @Column(name = "long_url", nullable = false)
    private String longUrl;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "expire_at", nullable = false)
    private LocalDateTime expireAt;

}

