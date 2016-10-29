package com.iamtek.hibernate.crud;

import com.iamtek.hibernate.crud.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Read {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Read
        session.beginTransaction();
        UserDetails1 user = session.get(UserDetails1.class, 5);
        System.out.println("User name pulled up is : " + user.getUserName());
        session.getTransaction().commit();

        session.close();
        System.out.println("User name pulled up is : " + user.getUserName());
        sessionFactory.close();

    }
}
