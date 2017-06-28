package com.kallapiran.service;

import com.kallapiran.entity.Reading;
import com.kallapiran.entity.Tire;
import com.kallapiran.entity.Vehicle;
import com.kallapiran.exception.ResourceNotFoundException;
import com.kallapiran.repository.AlertRepository;
import com.kallapiran.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService{
    @Autowired
    ReadingRepository readingRepository;


    @Autowired
    AlertRepository alertRepository;

//    constant
    private static final double percentOfFuel = 0.1;

    @Transactional
    public Reading putReading(Reading reading) {
        Reading updatedEntity = readingRepository.putDetails(reading);
        if(updatedEntity != null){
            checkForAlerts(updatedEntity);
            return reading;
        }else{
            throw new ResourceNotFoundException("The Vehicle associated with the reading cannot be found");
        }

    }

    @Transactional
    private void checkForAlerts(Reading readToBeChecked){
        Vehicle associatedVeh = readToBeChecked.getVehicle();
        checkForEngineRpm(readToBeChecked, associatedVeh);
        checkForFuelVolume(readToBeChecked, associatedVeh);
        checkForTirePressure(readToBeChecked);
        checkForEngineCoolant(readToBeChecked);
    }

    @Transactional
    private void checkForEngineRpm(Reading readToBeChecked, Vehicle assocVeh){
        if(readToBeChecked.getEngineRpm() > assocVeh.getRedlineRpm()){
            alertRepository.createHighPriorityAlert(readToBeChecked);
        }
    }

    @Transactional
    private void checkForFuelVolume(Reading readToBeChecked, Vehicle assocVeh){
        if(readToBeChecked.getFuelVolume() < (percentOfFuel*(assocVeh.getMaxFuelVolume()))){
            alertRepository.createMediumPriorityAlert(readToBeChecked);
        }
    }

    @Transactional
    private void checkForTirePressure(Reading readToBeChecked){
        Tire tire = readToBeChecked.getTires();
        double frontLeftTire = tire.getFrontLeft();
        double frontRightTire = tire.getFrontRight();
        double rearLeftTire = tire.getRearLeft();
        double rearRightTire = tire.getRearRight();

        if(frontLeftTire > 36 || frontLeftTire < 32 || frontRightTire > 36 || frontRightTire < 32 ||
                rearLeftTire > 36 || rearLeftTire < 32 || rearRightTire >36 || rearRightTire < 32){
            alertRepository.createLowPriorityAlert(readToBeChecked);
        }
    }

    @Transactional
    private void checkForEngineCoolant(Reading readToBeChecked){
        if(readToBeChecked.isEngineCoolantLow() || readToBeChecked.isCheckEngineLightOn()){
            alertRepository.createLowPriorityAlert(readToBeChecked);
        }
    }
}
