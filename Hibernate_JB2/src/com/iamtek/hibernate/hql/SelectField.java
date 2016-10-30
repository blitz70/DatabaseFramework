package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SelectField {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //Prepare data
        Data.create(sessionFactory);

        //HQL
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT userName FROM UserDetails");

        List users = query.list();
        session.getTransaction().commit();
        session.close();

        for (String user : (List<String>)users) {
            System.out.println(user);
        }

        sessionFactory.close();
    }

}
