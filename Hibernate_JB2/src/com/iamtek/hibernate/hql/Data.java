package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Data {

    //Create data for HQL
    public static void create(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            for (int i = 1; i < 11; i++) {
                UserDetails user = new UserDetails();
                user.setUserName("User " + i);
                session.save(user);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
