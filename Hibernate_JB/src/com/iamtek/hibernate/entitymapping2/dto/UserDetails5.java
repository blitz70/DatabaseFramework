package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails5 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @OneToMany
    @JoinTable(
            name = "USER_VEHICLE"
            , joinColumns = @JoinColumn(name = "USER_ID")
            , inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
    )
    private Collection<Vehicle> vehicle = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

}
