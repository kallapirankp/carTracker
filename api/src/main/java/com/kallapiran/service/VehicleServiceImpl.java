package com.kallapiran.service;


import com.kallapiran.entity.Vehicle;
import com.kallapiran.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public List<Vehicle> putDetails(List<Vehicle> vehicles) {
        vehicleRepository.putDetails(vehicles);
        return vehicles;
    }
}
