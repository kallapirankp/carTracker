package com.kallapiran.controller;

import com.kallapiran.entity.GeoLocation;
import com.kallapiran.entity.HistoricalAlert;
import com.kallapiran.entity.Reading;
import com.kallapiran.entity.SpecificVariable;
import com.kallapiran.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/readings")
public class ReadingController {
    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST)
    public Reading putReadings(@RequestBody Reading reading){
        return readingService.putReading(reading);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSpecificSignal/{vinId}/{property}/{time}")
    public List<SpecificVariable> getSpecificReadingDetails(@PathVariable String vinId, @PathVariable String property, @PathVariable int time){
        return readingService.getSpecificReadingDetails(vinId, property, time);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geoLocation/{vinId}")
    public List<GeoLocation> getVehicleGeoLocation(@PathVariable String vinId){
        return readingService.getVehicleGeoLocation(vinId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getHistoricalAlerts/{vinId}")
    public List<HistoricalAlert> getVehicleHistoricalAlerts(@PathVariable String vinId){
        return readingService.getVehicleHistoricalAlert(vinId);
    }
}
