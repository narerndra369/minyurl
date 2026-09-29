package com.minyurl.redirect.repository;

import com.minyurl.redirect.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UrlMappingRepo extends JpaRepository<UrlMapping, String> {

    Optional<UrlMapping> findByShortCode(String shortCode);
}
