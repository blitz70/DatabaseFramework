package com.iamtek.hibernate.inheritance.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler3 extends Vehicle3 {

    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
