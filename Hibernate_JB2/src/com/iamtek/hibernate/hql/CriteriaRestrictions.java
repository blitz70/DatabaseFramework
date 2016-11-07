package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@SuppressWarnings("deprecation")
public class CriteriaRestrictions {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session;
        Criteria criteria;

        //Prepare data
        Data.create(sessionFactory);

        session = sessionFactory.openSession();
        session.beginTransaction();
        criteria = session.createCriteria(UserDetails1.class);
        //criteria.add(Restrictions.eq("userName", "User 10"));
        //criteria.add(Restrictions.gt("userId", 3)).add(Restrictions.between("userId", 5, 9));
        criteria.add(Restrictions.or(
                Restrictions.between("userId", 0, 3),
                Restrictions.eq("userName", "User 10")
        ));
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
