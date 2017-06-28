package com.kallapiran.repository;

import com.kallapiran.entity.Reading;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository {
    void createHighPriorityAlert(Reading reading);
    void createMediumPriorityAlert(Reading reading);
    void createLowPriorityAlert(Reading reading);

}
