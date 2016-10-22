package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserId(3);
        user.setUserName("3rd User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        /*SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(UserDetails.class)
                .buildSessionFactory(); //same as adding entity classes in hibernate.cfg.xml*/
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        sessionFactory.close();

    }
}
