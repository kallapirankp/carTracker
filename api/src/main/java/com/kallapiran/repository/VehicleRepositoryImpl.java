package com.kallapiran.repository;

import com.kallapiran.entity.Alert;
import com.kallapiran.entity.AlertCount;
import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager em;

    public Vehicle findVehicle(Vehicle vehicle) {
        return em.find(Vehicle.class, vehicle.getVin());
    }

    public void createVehicle(Vehicle vehicle) {
        em.persist(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        em.merge(vehicle);
    }


    public List<Vehicle> getAllVehicleDetails(){
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAllVehicles", Vehicle.class);
        return query.getResultList();
    }

    public List<AlertCount> getVehicleWithHighAlerts(Timestamp twoHourAgo) {

        TypedQuery<AlertCount> query = em.createNamedQuery("Vehicle.findVehicleWithHighAlerts", AlertCount.class);
        query.setParameter("timeFilter", twoHourAgo);
        List<AlertCount> returnedResult = query.getResultList();
        return returnedResult;
    }

}
