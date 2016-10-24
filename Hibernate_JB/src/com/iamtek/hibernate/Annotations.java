package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails2;
import com.iamtek.hibernate.dto.UserDetails5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Annotations {

    public static void main(String[] args) {

        UserDetails2 user = new UserDetails2();
        user.setUserId(1);
        user.setUserName("First user");
        user.setAddress("First user address");
        user.setJoinedDate(new Date());
        user.setDescription("First user desc");
        user.setTransientField("not saved");

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails2.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}