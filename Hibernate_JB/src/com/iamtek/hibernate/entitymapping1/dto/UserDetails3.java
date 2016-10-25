package com.iamtek.hibernate.entitymapping1.dto;

import javax.persistence.*;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails3 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName + " from getter";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
