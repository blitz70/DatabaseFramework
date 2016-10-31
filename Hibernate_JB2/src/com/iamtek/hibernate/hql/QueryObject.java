package com.iamtek.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class QueryObject {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //Prepare data
        Data.create(sessionFactory);

        //HQL
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from UserDetails1 where userId > 5");

        List users = query.list();
        session.getTransaction().commit();
        session.close();
        System.out.println("Size of list = " + users.size());

        sessionFactory.close();
    }

}
