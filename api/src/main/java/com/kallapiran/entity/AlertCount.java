package com.kallapiran.entity;


import java.util.HashMap;
import java.util.Map;

// This class is used to output number of high alerts for all Vehicles as JSON
public class AlertCount {
    private Vehicle vehicle;
    private long count;

    public AlertCount(Vehicle vehicle, long count){
        this.vehicle = vehicle;
        this.count = count;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
