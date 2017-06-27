package com.kallapiran.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Embeddable
public class Tire {

    private double frontLeft;
    private double frontRight;
    private double rearLeft;
    private double rearRight;


// Getters and Setters

    public double getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(double frontLeft) {
        this.frontLeft = frontLeft;
    }

    public double getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(double frontRight) {
        this.frontRight = frontRight;
    }

    public double getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(double rearLeft) {
        this.rearLeft = rearLeft;
    }

    public double getRearRight() {
        return rearRight;
    }

    public void setRearRight(double rearRight) {
        this.rearRight = rearRight;
    }
}
