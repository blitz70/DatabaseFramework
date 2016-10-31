package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Parameter {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //Prepare data
        Data.create(sessionFactory);

        //HQL
        String p1= "5";
        String p2= "User 10";

        // Parameter position binding
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /* SQL injection hacking!
        String minUserId = "5 or 1 = 1";
        Query query = session.createQuery("FROM UserDetails1 WHERE userId > " + minUserId);
        */
        Query query = session.createQuery("FROM UserDetails1 WHERE userId > ? AND userName = ?");
        query.setParameter(0, Integer.parseInt(p1));
        query.setParameter(1, p2);
        List<UserDetails1> users = (List<UserDetails1>) query.list();
        session.getTransaction().commit();
        session.close();
        display(users);

        // Parameter name binding
        session = sessionFactory.openSession();
        session.beginTransaction();
        query = session.createQuery("FROM UserDetails1 WHERE userId > :param1 AND userName = :param2");
        query.setParameter("param1", Integer.parseInt(p1));
        query.setParameter("param2", p2);
        users = (List<UserDetails1>) query.list();
        session.getTransaction().commit();
        session.close();
        display(users);

        sessionFactory.close();
    }

    public static void display(List<UserDetails1> users) {
        for (UserDetails1 user : users) {
            System.out.println(user.getUserName());
        }
    }

}
