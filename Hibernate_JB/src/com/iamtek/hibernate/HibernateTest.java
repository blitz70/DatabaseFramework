package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails1 user = new UserDetails1();
        user.setUserId(3);
        user.setUserName("Third user");

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
