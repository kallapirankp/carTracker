package com.kallapiran.repository;

import com.kallapiran.entity.Tire;
import org.springframework.stereotype.Repository;

@Repository
public interface TireRepository {

    void putDetails(Tire tireDetails);
}
