package com.iamtek.hibernate.entitymapping1;

import com.iamtek.hibernate.entitymapping1.dto.Address;
import com.iamtek.hibernate.entitymapping1.dto.UserDetails4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ValueObject1 {

    public static void main(String[] args) {

        UserDetails4 user = new UserDetails4();
        user.setUserName("First user");

        Address addr = new Address();
        addr.setStreet("Street name");
        addr.setCity("City name");

        user.setAddress(addr);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails4.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
