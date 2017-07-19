package com.kallapiran.service;


import com.kallapiran.entity.AlertCount;
import com.kallapiran.entity.GeoLocation;
import com.kallapiran.entity.Reading;
import com.kallapiran.entity.Vehicle;
import com.kallapiran.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<AlertCount> getVehicleWithHighAlerts() {
        Timestamp twoHourAgo = new Timestamp(System.currentTimeMillis() - (120 * 60 * 1000));

        return vehicleRepository.getVehicleWithHighAlerts(twoHourAgo);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicleDetails() {
        return vehicleRepository.getAllVehicleDetails();
    }

    @Transactional
    public List<Vehicle> putDetails(List<Vehicle> vehicles) {
        for(Vehicle v : vehicles){
            Vehicle returnedVehicle = vehicleRepository.findVehicle(v);
            if(returnedVehicle == null){
                vehicleRepository.createVehicle(v);
            }else{
                vehicleRepository.updateVehicle(returnedVehicle);
            }
        }
        return vehicles;
    }


}
