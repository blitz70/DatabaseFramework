package com.iamtek.hibernate.hql;

import com.iamtek.hibernate.hql.dto.UserDetails2;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Criteria1 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session;
        Criteria criteria;

        //Prepare data
        Data.create(sessionFactory);

        session = sessionFactory.openSession();
        session.beginTransaction();
        criteria = session.createCriteria(UserDetails2.class);
        //criteria.add(Restrictions.eq("userName", "User 10"));
        criteria.add(Restrictions.or(
                Restrictions.between("userId", 0, 3),
                Restrictions.between("userId", 7,10)
        ));
        List users = criteria.list();

        session.getTransaction().commit();
        session.close();
        display(users);

        sessionFactory.close();

    }

    public static void display(List<UserDetails2> users) {
        for (UserDetails2 user : users) {
            System.out.println(user.getUserName());
        }
    }

}
