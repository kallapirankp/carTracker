package com.kallapiran.entity;

import java.sql.Timestamp;

//this class is used for sending the json with values for specific variables in Reading class instead
//of sending the entire Reading class

public class SpecificVariable {
    private Double value;
    private Timestamp timestamp;

    public SpecificVariable(Double value, Timestamp timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
