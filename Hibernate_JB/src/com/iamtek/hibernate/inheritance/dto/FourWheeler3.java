package com.iamtek.hibernate.inheritance.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler3 extends Vehicle3 {

    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
