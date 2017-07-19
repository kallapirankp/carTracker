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


    public void createHighPriorityAlert(Reading reading, String alertMessage) {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAlertByReading", Alert.class);
        query.setParameter("readValue", reading);
        List<Alert> returnedResults = query.getResultList();
        if(returnedResults != null && returnedResults.size() == 1){
            Alert a = returnedResults.get(0);
            a.setHigh(true);
            a.setHighAlertType(alertMessage);
            em.merge(a);
        }else {
            Alert a = new Alert();
            a.setReading(reading);
            a.setHigh(true);
            a.setHighAlertType(alertMessage);
            a.setLow(false);
            a.setMedium(false);
            em.persist(a);
        }
    }

    public void createMediumPriorityAlert(Reading reading, String alertMessage) {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAlertByReading", Alert.class);
        query.setParameter("readValue", reading);
        List<Alert> returnedResults = query.getResultList();
        if(returnedResults != null && returnedResults.size() == 1){
            Alert a = returnedResults.get(0);
            a.setMedium(true);
            a.setMediumAlertType(alertMessage);
            em.merge(a);
        }else {
            Alert a = new Alert();
            a.setReading(reading);
            a.setHigh(false);
            a.setMedium(true);
            a.setMediumAlertType(alertMessage);
            a.setLow(false);
            em.persist(a);
        }

    }

    public void createLowPriorityAlert(Reading reading, String alertMessage, boolean alertType) {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAlertByReading", Alert.class);
        query.setParameter("readValue", reading);
        List<Alert> returnedResults = query.getResultList();
        if(returnedResults != null && returnedResults.size() == 1) {
            Alert a = returnedResults.get(0);
            a.setLow(true);
            if(alertType){
                a.setLowAlertType1(alertMessage);
            }else{
                a.setLowAlertType2(alertMessage);
            }
            em.merge(a);
        }else {
            Alert a = new Alert();
            a.setReading(reading);
            a.setHigh(false);
            a.setMedium(false);
            a.setLow(true);
            if(alertType){
                a.setLowAlertType1(alertMessage);
            }else{
                a.setLowAlertType2(alertMessage);
            }
            em.persist(a);
        }
    }
}
