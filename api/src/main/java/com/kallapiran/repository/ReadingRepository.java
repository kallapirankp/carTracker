package com.kallapiran.repository;

import com.kallapiran.entity.GeoLocation;
import com.kallapiran.entity.HistoricalAlert;
import com.kallapiran.entity.Reading;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ReadingRepository {
    Reading putDetails(Reading reading);
    List<Reading> getSpecificReadings(String vinId, Timestamp time);
    List<GeoLocation> getVehicleGeoLocation(String vinId, Timestamp time);
    List<HistoricalAlert> getVehicleHistoricalAlert(String vinId);
}
