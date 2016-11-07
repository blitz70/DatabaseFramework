package com.iamtek.hibernate.hql;


import com.iamtek.hibernate.hql.dto.UserDetails1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import java.util.List;

@SuppressWarnings("deprecation")
public class QueryByExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session;
        Criteria criteria;

        Data.create(sessionFactory);

        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails1 exampleUser = new UserDetails1();
        //exampleUser.setUserId(5);
        exampleUser.setUserName("User 1%");
        Example example = Example.create(exampleUser).enableLike();
        criteria = session.createCriteria(UserDetails1.class).add(example);
        List users = criteria.list();
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
