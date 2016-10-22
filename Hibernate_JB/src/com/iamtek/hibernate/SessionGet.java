package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class SessionGet {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserId(2);
        user.setUserName("2 user");
        user.setAddress("2 user address");
        user.setJoinedDate(new Date());
        user.setDescription("2 user desc");
        user.setTransientField("not saved");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        user = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(UserDetails.class, 2);
        System.out.println("user name retrieved is " + user.getUserName());

    }
}
