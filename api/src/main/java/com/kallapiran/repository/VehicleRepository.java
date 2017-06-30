package com.kallapiran.repository;


import com.kallapiran.entity.AlertCount;
import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository {
    Vehicle findVehicle(Vehicle vehicle);
    void createVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicleDetails();
    AlertCount getVehicleWithHighAlerts();
}
