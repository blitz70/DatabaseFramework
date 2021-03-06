package com.iamtek.hibernate.entitymapping;

import com.iamtek.hibernate.entitymapping.dto.UserDetails2;
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

        SessionFactory sessionFactory = new Configuration().configure("com/iamtek/hibernate/entitymapping/hibernate.cfg1.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
