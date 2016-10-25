package com.iamtek.hibernate.entitymapping1.dto;

import javax.persistence.*;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails4 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    @Embedded
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
