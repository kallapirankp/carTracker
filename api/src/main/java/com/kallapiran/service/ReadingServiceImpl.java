package com.kallapiran.service;

import com.kallapiran.entity.*;
import com.kallapiran.exception.ResourceNotFoundException;
import com.kallapiran.repository.AlertRepository;
import com.kallapiran.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    private void checkForAlerts(Reading readToBeChecked){
        Vehicle associatedVeh = readToBeChecked.getVehicle();
        checkForEngineRpm(readToBeChecked, associatedVeh);
        checkForFuelVolume(readToBeChecked, associatedVeh);
        checkForTirePressure(readToBeChecked);
        checkForEngineCoolant(readToBeChecked);
    }

    private void checkForEngineRpm(Reading readToBeChecked, Vehicle assocVeh){
        if(readToBeChecked.getEngineRpm() > assocVeh.getRedlineRpm()){
            alertRepository.createHighPriorityAlert(readToBeChecked, "High Engine RPM");
        }
    }

    private void checkForFuelVolume(Reading readToBeChecked, Vehicle assocVeh){
        if(readToBeChecked.getFuelVolume() < (percentOfFuel*(assocVeh.getMaxFuelVolume()))){
            alertRepository.createMediumPriorityAlert(readToBeChecked, "Low Fuel Volume");
        }
    }

    private void checkForTirePressure(Reading readToBeChecked){
        Tire tire = readToBeChecked.getTires();
        double frontLeftTire = tire.getFrontLeft();
        double frontRightTire = tire.getFrontRight();
        double rearLeftTire = tire.getRearLeft();
        double rearRightTire = tire.getRearRight();

        if(frontLeftTire > 36 || frontLeftTire < 32 || frontRightTire > 36 || frontRightTire < 32 ||
                rearLeftTire > 36 || rearLeftTire < 32 || rearRightTire >36 || rearRightTire < 32){
//            alertType is used as a parameter only to indicate the type of low priority alert
            alertRepository.createLowPriorityAlert(readToBeChecked, "Low Tire Pressure", true);
        }
    }


    private void checkForEngineCoolant(Reading readToBeChecked){
        if(readToBeChecked.isEngineCoolantLow() || readToBeChecked.isCheckEngineLightOn()){
//            alertType is used as a parameter only to indicate the type of low priority alert
            alertRepository.createLowPriorityAlert(readToBeChecked, "Engine Coolant is Low/ Engine Light is ON", false);
        }
    }

    @Transactional(readOnly = true)
    public List<SpecificVariable> getSpecificReadingDetails(String vinId, String property, int time) {
        //Creating a timeStamp based on the user desired time.
        Timestamp timeToFetch;
        if(time == 15){
            timeToFetch = new Timestamp(System.currentTimeMillis() - (15 * 60 * 1000));
        }else if(time == 30){
            timeToFetch = new Timestamp(System.currentTimeMillis() - (30 * 60 * 1000));
        }else if(time == 60){
            timeToFetch = new Timestamp(System.currentTimeMillis() - (60 * 60 * 1000));
        }else{
            timeToFetch = new Timestamp(System.currentTimeMillis() - (120 * 60 * 1000));
        }

//        calling the repository to fetch all the readings for the particular time interval
        List<Reading> returnedQuery = readingRepository.getSpecificReadings(vinId, timeToFetch);

//         A list to store the objects that have only properties
        List<SpecificVariable> listOfObjects = new ArrayList<>();


//        based on the user requested column, we create a new class to only send that column value
//        (desired instance variable) instead of sending the entire class.
        switch (property) {

            case "fuelVolume":
//              The fuelVolume over the user specified time range is sent as json using SpecificVariable
//              class which sends list of json objects that only has fuelVolume and time as properties.
                for(Reading r : returnedQuery){
                    listOfObjects.add(new SpecificVariable(r.getFuelVolume(), r.getTimestamp()));
                }
                return listOfObjects;

            case "speed" :
                for(Reading r : returnedQuery){
                    listOfObjects.add(new SpecificVariable(r.getSpeed(), r.getTimestamp()));
                }
                return listOfObjects;

            case "engineRpm" :
                for(Reading r : returnedQuery){
                    listOfObjects.add(new SpecificVariable(r.getEngineRpm(), r.getTimestamp()));
                }
                return listOfObjects;

            case "engineHp" :
                for(Reading r : returnedQuery){
                    listOfObjects.add(new SpecificVariable(r.getEngineHp(), r.getTimestamp()));
                }
                return listOfObjects;

            default:
                return null;
        }
    }

    @Transactional(readOnly = true)
    public List<GeoLocation> getVehicleGeoLocation(String vinId) {
        return readingRepository.getVehicleGeoLocation(vinId, new Timestamp(System.currentTimeMillis() - (30 * 60 *1000)));
    }

    @Transactional(readOnly = true)
    public List<HistoricalAlert> getVehicleHistoricalAlert(String vinId) {
        return readingRepository.getVehicleHistoricalAlert(vinId);
    }
}
