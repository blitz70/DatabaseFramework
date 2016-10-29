package com.iamtek.hibernate.crud;

import com.iamtek.hibernate.crud.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectStates {

    public static void main(String[] args) {

        UserDetails1 user = new UserDetails1();
        user.setUserName("Test user");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        user.setUserName("1 Updated user");
        session.save(user);
        user.setUserName("2 Updated user");
        user.setUserName("3 Updated user");
        user.setUserName("4 Updated user");
        session.getTransaction().commit();

        session.close();
        user.setUserName("5 Updated user");
        sessionFactory.close();

    }
}
