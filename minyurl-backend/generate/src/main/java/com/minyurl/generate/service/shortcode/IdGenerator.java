package com.minyurl.generate.service.shortcode;

import com.minyurl.generate.repository.UrlSequenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdGenerator {
    @Autowired
    private UrlSequenceRepo urlSequenceRepo;
    private final int BLOCK_SIZE = 10_000;
    private long curId = 0;
    private long maxId = 0;

    public synchronized long nextId(){
        if(curId >= maxId){
            fetchNextId();
        }
        return curId++;
    }

    private void fetchNextId(){
        urlSequenceRepo.incrementSequence(BLOCK_SIZE);
        long maxSeq = urlSequenceRepo.getCurrentSequence();
        maxId = maxSeq;
        curId = maxId - BLOCK_SIZE;
    }

}
