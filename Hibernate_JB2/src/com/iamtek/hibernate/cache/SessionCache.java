package com.iamtek.hibernate.cache;

import com.iamtek.hibernate.cache.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCache {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).buildSessionFactory();

        //data
        Data.create(sessionFactory);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails1 user = session.get(UserDetails1.class, 1);
        user.setUserName("1st updated user");
        UserDetails1 user2 = session.get(UserDetails1.class, 1);
        user2.setUserName("2nd updated user");
        UserDetails1 user3 = session.get(UserDetails1.class, 1);
        user3.setUserName("3rd updated user");
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}
