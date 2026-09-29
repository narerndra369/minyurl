package com.minyurl.generate.repository;

import com.minyurl.generate.model.UrlSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UrlSequenceRepo extends JpaRepository<UrlSequence, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE UrlSequence u SET u.sequence = u.sequence + :blockSize")
    void incrementSequence(@Param("blockSize") int blockSize);

    @Query("SELECT u.sequence FROM UrlSequence u WHERE u.id = 1")
    long getCurrentSequence();
}
