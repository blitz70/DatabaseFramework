package com.iamtek.hibernate.valueobject.dto;


import javax.persistence.*;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails2 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME"))
            , @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME"))
            , @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME"))
            , @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE"))
    })
    private Address homeAddress;
    private Address officeAddress;

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

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
