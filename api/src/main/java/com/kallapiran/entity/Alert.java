package com.kallapiran.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name="Alert.findAlertByReading",
        query = "SELECT a FROM Alert a WHERE a.reading = :readValue"),
        @NamedQuery(name = "Alert.getHistoricalAlert",
                    query = "SELECT NEW com.kallapiran.entity.HistoricalAlert(a, r.timestamp) FROM Reading r JOIN Alert a ON a.reading = r WHERE r.vehicle.Vin = :vinId")
})
public class Alert {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private boolean high;
    private String highAlertType;
    private boolean low;
    private String lowAlertType1;
    private String lowAlertType2;
    private boolean medium;
    private String mediumAlertType;

    @JsonIgnore
    @OneToOne
    private Reading reading;

    public Alert(){
        this.id = UUID.randomUUID().toString();
    }

//    Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHigh() {
        return high;
    }

    public void setHigh(boolean high) {
        this.high = high;
    }

    public boolean isLow() {
        return low;
    }

    public void setLow(boolean low) {
        this.low = low;
    }

    public boolean isMedium() {
        return medium;
    }

    public void setMedium(boolean medium) {
        this.medium = medium;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public String getHighAlertType() {
        return highAlertType;
    }

    public void setHighAlertType(String highAlertType) {
        this.highAlertType = highAlertType;
    }

    public String getLowAlertType1() {
        return lowAlertType1;
    }

    public void setLowAlertType1(String lowAlertType1) {
        this.lowAlertType1 = lowAlertType1;
    }

    public String getLowAlertType2() {
        return lowAlertType2;
    }

    public void setLowAlertType2(String lowAlertType2) {
        this.lowAlertType2 = lowAlertType2;
    }

    public String getMediumAlertType() {
        return mediumAlertType;
    }

    public void setMediumAlertType(String mediumAlertType) {
        this.mediumAlertType = mediumAlertType;
    }
}
