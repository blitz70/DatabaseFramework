package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails3 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @OneToMany
    @JoinTable(
            name = "USER_VEHICLE"
            , joinColumns = @JoinColumn(name = "USER_ID")
            , inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
    )
    private Collection<Vehicle3> vehicle = new ArrayList<>();

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

    public Collection<Vehicle3> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle3> vehicle) {
        this.vehicle = vehicle;
    }

}
