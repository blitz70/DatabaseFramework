package com.iamtek.hibernate.crud;

import com.iamtek.hibernate.crud.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Detached {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails1 newUser = new UserDetails1();
        newUser.setUserName("New user");
        session.save(newUser);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails1 user = session.get(UserDetails1.class, 1);
        session.getTransaction().commit();
        session.close();

        //user.setUserName("1st update user after session close");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();

        user.setUserName("2nd update user after session close");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

    }
}
