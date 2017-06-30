package com.kallapiran.controller;

import com.kallapiran.entity.Reading;
import com.kallapiran.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RequestMapping(value = "/readings")
public class ReadingController {
    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST)
    public Reading putReadings(@RequestBody Reading reading){
        return readingService.putReading(reading);
    }
}
