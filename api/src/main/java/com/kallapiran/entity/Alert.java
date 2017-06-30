package com.kallapiran.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name="Alert.findAlertByReading",
        query = "SELECT a FROM Alert a WHERE a.reading = :readValue"),

})
public class Alert {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private boolean high;
    private boolean low;
    private boolean medium;


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
}
