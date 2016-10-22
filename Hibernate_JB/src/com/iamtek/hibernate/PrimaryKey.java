package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class PrimaryKey {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserId(10);  //is ignored
        user.setUserName("First user");

        UserDetails user2 = new UserDetails();
        user2.setUserName("Second user");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

    }
}
