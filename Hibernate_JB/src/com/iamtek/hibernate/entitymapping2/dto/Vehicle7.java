package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "VEHICLE")

public class Vehicle7 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    private String vehicleName;

    @ManyToMany(mappedBy = "vehicleList")
    private Collection<UserDetails7> userList = new ArrayList<>();

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

    public Collection<UserDetails7> getUserList() {
        return userList;
    }

    public void setUserList(Collection<UserDetails7> userList) {
        this.userList = userList;
    }
}
