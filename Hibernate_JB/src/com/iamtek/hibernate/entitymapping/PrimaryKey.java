package com.iamtek.hibernate.entitymapping;

import com.iamtek.hibernate.entitymapping.dto.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey {

    public static void main(String[] args) {

        UserDetails3 user1 = new UserDetails3();
        user1.setUserId(10);  //is ignored
        user1.setUserName("First user");

        UserDetails3 user2 = new UserDetails3();
        user2.setUserName("Second user");

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails3.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

    }
}
