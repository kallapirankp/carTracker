package com.kallapiran.entity;


import java.util.HashMap;
import java.util.Map;

public class AlertCount {

   public Map<String, Integer> alertCountForEachVehicle = new HashMap<String, Integer>();

    public Map<String, Integer> getAlertCountForEachVehicle() {
        return alertCountForEachVehicle;
    }

    public void setAlertCountForEachVehicle(Map<String, Integer> alertCountForEachVehicle) {
        this.alertCountForEachVehicle = alertCountForEachVehicle;
    }
}
