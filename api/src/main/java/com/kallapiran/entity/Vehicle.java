package com.kallapiran.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Vehicle.findByVin",
                    query = "SELECT v FROM Vehicle v WHERE v.Vin=:vin"),
        @NamedQuery(name="Vehicle.findAllVehicles",
                    query = "SELECT v FROM Vehicle v "),
        @NamedQuery(name="Vehicle.findVehicleWithHighAlerts",
                  query = "SELECT NEW com.kallapiran.entity.AlertCount(v, COUNT(a)) FROM Vehicle v JOIN v.reading r JOIN r.alert a WHERE a.high = true AND r.timestamp > :timeFilter GROUP BY v")
})
public class Vehicle {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    private String Vin;
    @Column(columnDefinition = "VARCHAR(30)")
    private String make;
    @Column(columnDefinition = "VARCHAR(30)")
    private String model;
    private int year;
    private double redlineRpm;
    private double maxFuelVolume;
    @Column(columnDefinition = "VARCHAR(24)")
    private String lastServiceDate;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    public List<Reading> reading = new ArrayList<Reading>();



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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(double redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public List<Reading> getReading() {
        return reading;
    }

    public void setReading(List<Reading> reading) {
        this.reading = reading;
    }
}
