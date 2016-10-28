package com.iamtek.hibernate.valueobject;

import com.iamtek.hibernate.valueobject.dto.Address;
import com.iamtek.hibernate.valueobject.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ValueObject1 {

    public static void main(String[] args) {

        UserDetails1 user = new UserDetails1();
        user.setUserName("First user");

        Address addr = new Address();
        addr.setStreet("Street name");
        addr.setCity("City name");

        user.setAddress(addr);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
