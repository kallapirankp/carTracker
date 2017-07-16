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

    public AlertCount getVehicleWithHighAlerts() {
        AlertCount a = new AlertCount();
        Timestamp twoHourAgo = new Timestamp(System.currentTimeMillis() - (120 * 60 * 1000));
        System.out.println("timeTwoHourAgo" + twoHourAgo);
        TypedQuery<Object[]> query = em.createNamedQuery("Vehicle.findVehicleWithHighAlerts", Object[].class);
        query.setParameter("timeFilter", twoHourAgo);
        for(Object result[] : query.getResultList()){
            Vehicle vehi = (Vehicle) result[0];
            Alert alt = (Alert) result[1];
            if(a.alertCountForEachVehicle.containsKey(vehi.getVin())){
                a.alertCountForEachVehicle.put(vehi.getVin(), a.alertCountForEachVehicle.get(vehi.getVin())+1 );
            }else{
                a.alertCountForEachVehicle.put(vehi.getVin(),1);
            }
        }

        return a;
    }

}
