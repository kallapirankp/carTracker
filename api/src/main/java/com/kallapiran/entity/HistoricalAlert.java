package com.kallapiran.entity;


import java.sql.Timestamp;
import java.util.Date;

public class HistoricalAlert {

    private Alert alert;
    private Timestamp timestamp;

    public HistoricalAlert(Alert alert, Date timestamp){
        this.alert = alert;
        this.timestamp = (Timestamp) timestamp;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
