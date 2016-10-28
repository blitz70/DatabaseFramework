package com.iamtek.hibernate.inheritance.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler2 extends Vehicle2 {

    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
