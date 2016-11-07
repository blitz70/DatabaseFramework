package com.iamtek.hibernate.crud;

import com.iamtek.hibernate.crud.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Data.create(sessionFactory);

        session.beginTransaction();
        UserDetails1 user = session.get(UserDetails1.class, 5);
        user.setUserName("Updated User");
        session.update(user);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}
