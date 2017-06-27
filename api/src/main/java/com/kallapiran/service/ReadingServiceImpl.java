package com.kallapiran.service;

import com.kallapiran.entity.Reading;
import com.kallapiran.repository.ReadingRepository;
import com.kallapiran.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    TireRepository tireRepository;

    @Transactional
    public Reading putReading(Reading reading) {
        tireRepository.putDetails(reading.getTires());
        readingRepository.putDetails(reading);
        return reading;
    }
}
