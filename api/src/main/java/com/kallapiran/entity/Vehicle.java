package com.kallapiran.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Vehicle.findByVin",
                    query = "SELECT v FROM Vehicle v WHERE v.Vin=:vin")
})
public class Vehicle {
    @Id
    private String Vin;
    private String make;
    private String model;
    private String year;
    private String redlineRpm;
    private String maxFuelVolume;
    private String lastServiceDate;

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(String redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public String getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(String maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
