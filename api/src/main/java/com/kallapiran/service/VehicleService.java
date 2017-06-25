package com.kallapiran.service;

import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<Vehicle> putDetails(List<Vehicle> vehicles);
}
