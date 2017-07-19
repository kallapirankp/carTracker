package com.kallapiran.service;

import com.kallapiran.entity.Alert;
import com.kallapiran.entity.AlertCount;
import com.kallapiran.entity.GeoLocation;
import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<Vehicle> putDetails(List<Vehicle> vehicles);
    List<Vehicle> getAllVehicleDetails();
    List<AlertCount> getVehicleWithHighAlerts();
}
