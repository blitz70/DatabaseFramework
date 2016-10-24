package com.iamtek.hibernate;

import com.iamtek.hibernate.dto.Address;
import com.iamtek.hibernate.dto.UserDetails4;
import com.iamtek.hibernate.dto.UserDetails5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ValueObject2 {

    public static void main(String[] args) {

        UserDetails5 user = new UserDetails5();
        user.setUserName("First user");

        Address addr1 = new Address();
        addr1.setStreet("Home street name");
        addr1.setCity("Home city name");
        user.setHomeAddress(addr1);

        Address addr2 = new Address();
        addr2.setStreet("Office Street name");
        addr2.setCity("Office City name");
        user.setOfficeAddress(addr2);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails5.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
