package com.iamtek.hibernate.entitymapping2.dto;

import javax.persistence.*;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails2 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @OneToOne @JoinColumn(name = "VEHICLE_ID")
    private Vehicle2 vehicle;

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

    public Vehicle2 getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle2 vehicle) {
        this.vehicle = vehicle;
    }

}
