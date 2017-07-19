package com.kallapiran.repository;

import com.kallapiran.entity.GeoLocation;
import com.kallapiran.entity.HistoricalAlert;
import com.kallapiran.entity.Reading;
import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager em;

    public Reading putDetails(Reading reading) {
        Vehicle v = em.find(Vehicle.class, reading.getVin());
        if(v != null){
            reading.setVehicle(v);
            v.reading.add(reading);
            em.persist(reading);
            return reading;
        }else{
            return null;
        }
    }

    public List<Reading> getSpecificReadings(String vinId, Timestamp time) {
        TypedQuery<Reading> query = em.createNamedQuery("Reading.getSpecificReadings", Reading.class);
        query.setParameter("vinId", vinId);
        query.setParameter("time", time);
        List<Reading> returnedList = new ArrayList<Reading>();
        for(Reading r : query.getResultList()){
            returnedList.add(r);
        }
        return returnedList;
    }

    public List<GeoLocation> getVehicleGeoLocation(String vinId, Timestamp time) {
        TypedQuery<GeoLocation> query = em.createNamedQuery("Reading.getVehicleGeoLocation", GeoLocation.class);
        query.setParameter("vinId", vinId);
        query.setParameter("time", time);
        List<GeoLocation> queryResult = query.getResultList();
        return queryResult;
    }


    public List<HistoricalAlert> getVehicleHistoricalAlert(String vinId) {
        TypedQuery<HistoricalAlert> query = em.createNamedQuery("Alert.getHistoricalAlert", HistoricalAlert.class);
        query.setParameter("vinId", vinId);
        List<HistoricalAlert> queryResult = query.getResultList();
        return queryResult;
    }
}
