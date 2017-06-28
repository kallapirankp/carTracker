package com.kallapiran.repository;

import com.kallapiran.entity.Alert;
import com.kallapiran.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertRepository{

    @PersistenceContext
    private EntityManager em;


    public void createHighPriorityAlert(Reading reading) {
        Alert a = new Alert();
        a.setReading(reading);
        a.setHigh(true);
        a.setLow(false);
        a.setMedium(false);
        em.persist(a);
    }

    public void createMediumPriorityAlert(Reading reading) {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAlertByReading", Alert.class);
        query.setParameter("readValue", reading);
        List<Alert> returnedResults = query.getResultList();
        if(returnedResults != null && returnedResults.size() == 1){
            Alert a = returnedResults.get(0);
            a.setLow(true);
            em.merge(a);
        }else if(returnedResults.size() == 0){
            Alert a = new Alert();
            a.setReading(reading);
            a.setHigh(false);
            a.setLow(true);
            a.setMedium(false);
            em.persist(a);
        }

    }

    public void createLowPriorityAlert(Reading reading) {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAlertByReading", Alert.class);
        query.setParameter("readValue", reading);
        List<Alert> returnedResults = query.getResultList();
        if(returnedResults != null && returnedResults.size() == 1) {
            Alert a = returnedResults.get(0);
            a.setMedium(true);
            em.merge(a);
        }else if(returnedResults.size() == 0){
            Alert a = new Alert();
            a.setReading(reading);
            a.setHigh(false);
            a.setLow(false);
            a.setMedium(true);
            em.persist(a);
        }
    }
}
