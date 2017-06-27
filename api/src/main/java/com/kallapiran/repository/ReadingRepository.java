package com.kallapiran.repository;

import com.kallapiran.entity.Reading;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository {
    void putDetails(Reading reading);
}
