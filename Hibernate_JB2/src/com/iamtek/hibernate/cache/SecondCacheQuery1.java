package com.iamtek.hibernate.cache;

import com.iamtek.hibernate.cache.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SecondCacheQuery1 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).buildSessionFactory();

        //data
        Data.create(sessionFactory);

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query query1 = session1.createQuery("from UserDetails1 user where user.userId = 1");
        List users1 = query1.list();
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Query query2 = session2.createQuery("from UserDetails1 user where user.userId = 1");
        List users2 = query2.list();
        session2.getTransaction().commit();
        session2.close();

        sessionFactory.close( );
    }
}
