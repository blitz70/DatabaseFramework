package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails6 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @OneToMany(mappedBy = "user")
    private Collection<Vehicle6> vehicle = new ArrayList<>();

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

    public Collection<Vehicle6> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle6> vehicle) {
        this.vehicle = vehicle;
    }
}
