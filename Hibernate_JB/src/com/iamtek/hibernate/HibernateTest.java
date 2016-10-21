package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("First User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

    }
}
