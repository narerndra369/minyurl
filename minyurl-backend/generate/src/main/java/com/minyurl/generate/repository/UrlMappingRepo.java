package com.minyurl.generate.repository;

import com.minyurl.generate.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UrlMappingRepo extends JpaRepository<UrlMapping, String> {
    Optional<UrlMapping> findByShortCode(String shortCode);
    // it automatically usages the index long url
    Optional<UrlMapping> findByLongUrl(String longUrl);

    Optional<UrlMapping> findByExpireAt(LocalDateTime expireAt);

    @Query("SELECT u FROM UrlMapping u WHERE u.shortCode = :code AND u.expireAt > :now")
    Optional<UrlMapping> findByShortCodeAndExpireAtAfter(@Param("code") String code,
                                                   @Param("now") LocalDateTime now);
}
