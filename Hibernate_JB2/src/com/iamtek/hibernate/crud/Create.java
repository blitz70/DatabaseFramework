package com.iamtek.hibernate.crud;

import com.iamtek.hibernate.crud.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Create
        session.beginTransaction();
        for (int i = 0; i < 10; i++) {
            UserDetails1 user = new UserDetails1();
            user.setUserName("User " + i);
            session.save(user);
        }
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}
