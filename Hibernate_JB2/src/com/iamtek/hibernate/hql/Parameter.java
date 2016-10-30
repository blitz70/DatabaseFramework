package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails;
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
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        /* SQL injection hacking!
        String minUserId = "5 or 1 = 1";
        Query query = session.createQuery("FROM UserDetails WHERE userId > " + minUserId);*/

        String p1= "5";
        String p2= "User 10";

        /* Parameter position binding
        Query query = session.createQuery("FROM UserDetails WHERE userId > ? AND userName = ?");
        query.setParameter(0, Integer.parseInt(p1));
        query.setParameter(1, p2);*/

        // Parameter name binding
        Query query = session.createQuery("FROM UserDetails WHERE userId > :param1 AND userName = :param2");
        query.setParameter("param1", Integer.parseInt(p1));
        query.setParameter("param2", p2);

        List<UserDetails> users = (List<UserDetails>) query.list();
        session.getTransaction().commit();
        session.close();

        for (UserDetails user : users) {
            System.out.println(user.getUserName());
        }

        sessionFactory.close();
    }

}
