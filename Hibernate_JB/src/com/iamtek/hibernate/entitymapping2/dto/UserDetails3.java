package com.iamtek.hibernate.entitymapping2.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails3 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    private Collection<Address> listOfAddress = new ArrayList<>();

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

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

}
