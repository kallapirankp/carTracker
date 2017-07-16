package com.kallapiran.controller;

import com.kallapiran.entity.Alert;
import com.kallapiran.entity.AlertCount;
import com.kallapiran.entity.Vehicle;
import com.kallapiran.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RequestMapping(value="/vehicles")
public class VehicleController{

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> putDetails(@RequestBody List<Vehicle> vehicles){
        return vehicleService.putDetails(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getAllVehicleDetails(){
        return vehicleService.getAllVehicleDetails();
    }

    @RequestMapping(method = RequestMethod.GET, value="/getHighAlerts")
    public AlertCount getVehicleWithHighAlerts(){
        return vehicleService.getVehicleWithHighAlerts();
    }

}
