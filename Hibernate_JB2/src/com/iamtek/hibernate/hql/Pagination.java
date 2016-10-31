package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Pagination {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //Prepare data
        Data.create(sessionFactory);

        //HQL
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from UserDetails1");
        query.setFirstResult(5);
        query.setMaxResults(4);

        List<UserDetails1> users = (List<UserDetails1>) query.list();
        session.getTransaction().commit();
        session.close();

        for (UserDetails1 user : users) {
            System.out.println(user.getUserName());
        }

        sessionFactory.close();
    }

}
