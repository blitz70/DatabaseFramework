package com.iamtek.hibernate.introduction;

import com.iamtek.hibernate.introduction.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserId(3);
        user.setUserName("Third user");

        SessionFactory sessionFactory = new Configuration().configure("com/iamtek/hibernate/entitymapping1/hibernate.cfg1.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
