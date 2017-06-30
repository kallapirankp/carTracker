package com.kallapiran.repository;

import com.kallapiran.entity.Reading;
import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
