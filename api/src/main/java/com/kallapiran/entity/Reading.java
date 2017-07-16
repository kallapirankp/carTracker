package com.kallapiran.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @ManyToOne()
    private Vehicle vehicle;

    private String vin;
    private double latitude;
    private double longitude;
    @Column(columnDefinition = "VARCHAR(24)")
    private Timestamp timestamp;
    private double fuelVolume;
    private double speed;
    private double engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private double engineRpm;

    @Embedded
    private Tire tires;

    @OneToOne(mappedBy = "reading")
    @JsonIgnore
    private Alert alert;


    //    Getter and setter methods

    public Reading(){

        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        DateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        try{
            Date date = d.parse(timestamp.replaceAll("Z$", "+0000"));
            this.timestamp = new Timestamp(date.getTime());
        }catch(ParseException e){
            System.out.println("Error in parsing" + e);
        }
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(double engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public double getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(double engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tire getTires() {
        return tires;
    }

    public void setTires(Tire tires) {
        this.tires = tires;
    }

    public Vehicle getVehicle() {

        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {

        this.vehicle = vehicle;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }


}
