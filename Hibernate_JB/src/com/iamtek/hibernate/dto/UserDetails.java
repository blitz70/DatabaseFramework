package com.iamtek.hibernate.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    private String address;
    @Lob
    private String description;
    @Transient
    private String transientField;

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

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransientField() {
        return transientField;
    }

    public void setTransientField(String transientField) {
        this.transientField = transientField;
    }
}
