package com.iamtek.hibernate.cache;

import com.iamtek.hibernate.cache.dto.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SecondCacheQuery2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg3.xml").addAnnotatedClass(UserDetails2.class).buildSessionFactory();

        //data
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i < 11; i++) {
            UserDetails2 user = new UserDetails2();
            user.setUserName("User " + i);
            session.save(user);
        }
        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query query1 = session1.createQuery("from UserDetails2 user where user.userId = 1").setCacheable(true);
        List users1 = query1.list();
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Query query2 = session2.createQuery("from UserDetails2 user where user.userId = 1").setCacheable(true);
        List users2 = query2.list();
        session2.getTransaction().commit();
        session2.close();

        sessionFactory.close( );
    }
}
