package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")

public class Vehicle6 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    private String vehicleName;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

}
