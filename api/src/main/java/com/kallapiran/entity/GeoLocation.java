package com.kallapiran.entity;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

//this class is to send geolocation of the vehicles as JSON
public class GeoLocation {

    private Timestamp time;
    private Double latitude;
    private Double longitude;

    public GeoLocation(Date time, Double latitude, Double longitude){
        this.time = (Timestamp) time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
