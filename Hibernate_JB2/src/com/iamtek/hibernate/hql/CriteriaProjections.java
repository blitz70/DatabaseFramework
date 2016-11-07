package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import java.util.List;

@SuppressWarnings("deprecation")
public class CriteriaProjections {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails1.class).buildSessionFactory();
        Session session;
        Criteria criteria;

        //Prepare data
        Data.create(sessionFactory);

        session = sessionFactory.openSession();
        session.beginTransaction();
        criteria = session.createCriteria(UserDetails1.class)
                .setProjection(Projections.property("userId"))
                .addOrder(Order.desc("userId"));
        /*criteria = session.createCriteria(UserDetails1.class)
                .setProjection(Projections.count("userId"));*/
        List users = criteria.list();
        session.getTransaction().commit();
        session.close();

        display(users);

        sessionFactory.close();
    }

    public static void display(List<Object> users) {
        for (Object user : users) {
            System.out.println(user);
        }
    }
}
