package com.kallapiran.service;

import com.kallapiran.entity.Reading;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadingService {
    Reading putReading(Reading reading);
}
