package com.kallapiran.repository;

import com.kallapiran.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager em;

    public void putDetails(List<Vehicle> vehicles) {

        for(Vehicle v : vehicles){
            Vehicle vhle = em.find(Vehicle.class, v.getVin());
            if(vhle == null){
                em.persist(v);
            }else{
                em.merge(v);
            }
        }
    }

}
