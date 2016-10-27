package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")

public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    private UserDetails5 user;

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

    public UserDetails5 getUser() {
        return user;
    }

    public void setUser(UserDetails5 user) {
        this.user = user;
    }
}
