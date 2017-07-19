package com.kallapiran.repository;


import com.kallapiran.entity.AlertCount;
import com.kallapiran.entity.Reading;
import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface VehicleRepository {
    Vehicle findVehicle(Vehicle vehicle);
    void createVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicleDetails();
    List<AlertCount> getVehicleWithHighAlerts(Timestamp twoHourAgo);
}
