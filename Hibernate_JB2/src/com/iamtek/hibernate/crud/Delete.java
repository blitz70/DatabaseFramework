package com.iamtek.hibernate.crud;


import com.iamtek.hibernate.crud.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Delete
        session.beginTransaction();
        UserDetails1 user = session.get(UserDetails1.class, 6);
        session.delete(user);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }

}
