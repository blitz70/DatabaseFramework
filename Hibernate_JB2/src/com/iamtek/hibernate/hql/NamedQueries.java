package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails1;
import com.iamtek.hibernate.hql.dto.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NamedQueries {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).addAnnotatedClass(UserDetails2.class).buildSessionFactory();
        Session session;
        Query query;

        //Prepare data
        Data.create(sessionFactory);


        //HQL
        session = sessionFactory.openSession();
        session.beginTransaction();
        query = session.getNamedQuery("userDetails.byId");
        query.setParameter(0, 2);
        List<UserDetails2> users = (List<UserDetails2>) query.list();
        session.getTransaction().commit();
        session.close();
        display(users);

        session = sessionFactory.openSession();
        session.beginTransaction();
        query = session.getNamedQuery("userDetails.byName");
        query.setParameter(0, "User 5");
        List users2 = query.list();
        session.getTransaction().commit();
        session.close();
        display(users2);

        sessionFactory.close();
    }

    public static void display(List<UserDetails2> users) {
        for (UserDetails2 user : users) {
            System.out.println(user.getUserName());
        }
    }

}
