package com.kallapiran.service;

import com.kallapiran.entity.GeoLocation;
import com.kallapiran.entity.HistoricalAlert;
import com.kallapiran.entity.Reading;
import com.kallapiran.entity.SpecificVariable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadingService{
    Reading putReading(Reading reading);
    List<SpecificVariable> getSpecificReadingDetails(String vinId, String property, int time);
    List<GeoLocation> getVehicleGeoLocation(String vinId);
    List<HistoricalAlert> getVehicleHistoricalAlert(String vinId);

}
