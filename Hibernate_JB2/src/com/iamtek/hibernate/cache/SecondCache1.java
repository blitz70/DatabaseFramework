package com.iamtek.hibernate.cache;

import com.iamtek.hibernate.cache.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCache1 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).buildSessionFactory();

        //data
        Data.create(sessionFactory);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails1 user = session.get(UserDetails1.class, 1);
        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        UserDetails1 user2 = session2.get(UserDetails1.class, 1);
        session2.getTransaction().commit();
        session2.close();
        sessionFactory.close( );
    }
}
