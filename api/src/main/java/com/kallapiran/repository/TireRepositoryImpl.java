package com.kallapiran.repository;


import com.kallapiran.entity.Tire;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TireRepositoryImpl implements TireRepository {

    @PersistenceContext
    EntityManager em;
    public void putDetails(Tire tireDetails) {
        em.persist(tireDetails);
    }
}
