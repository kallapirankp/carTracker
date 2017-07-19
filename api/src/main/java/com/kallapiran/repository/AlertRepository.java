package com.kallapiran.repository;

import com.kallapiran.entity.Reading;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository {
    void createHighPriorityAlert(Reading reading, String alertMessage);
    void createMediumPriorityAlert(Reading reading, String alertMessage);
    void createLowPriorityAlert(Reading reading, String alertMessage, boolean alertType);

}
