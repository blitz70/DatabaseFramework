package com.iamtek.hibernate.hql.dto;

import javax.persistence.*;

@Entity
@NamedQuery(name = "userDetails.byId", query = "FROM UserDetails2 WHERE userId = ?")
@NamedNativeQuery(name = "userDetails.byName", query = "SELECT * FROM USER_DETAILS WHERE userName = ?", resultClass = UserDetails2.class)
@Table(name = "USER_DETAILS")
public class UserDetails2 {

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
