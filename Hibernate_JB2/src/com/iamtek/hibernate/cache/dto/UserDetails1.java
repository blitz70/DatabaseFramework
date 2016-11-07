package com.iamtek.hibernate.cache.dto;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;

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

}
