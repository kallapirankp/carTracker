package com.kallapiran.repository;


import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository {
    void putDetails(List<Vehicle> vehicles);
}
