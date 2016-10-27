package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.Address;
import com.iamtek.hibernate.entitymapping2.dto.UserDetails2;
import com.iamtek.hibernate.entitymapping2.dto.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProxyObject {

    public static void main(String[] args) {

        UserDetails3 user = new UserDetails3();
        user.setUserName("First User");

        Address addr1 = new Address();
        addr1.setStreet("First Street");
        addr1.setCity("First City");
        addr1.setState("First State");
        addr1.setPincode("100001");

        Address addr2 = new Address();
        addr2.setStreet("Second Street");
        addr2.setCity("Second City");
        addr2.setState("Second State");
        addr2.setPincode("200002");

        user.getListOfAddress().add(addr1);
        user.getListOfAddress().add(addr2);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails3.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        user = null;

        session = sessionFactory.openSession();
        user = session.get(UserDetails3.class, 1);
        session.close();
        System.out.println(user.getUserId() + ", " + user.getUserName());
        System.out.println(user.getListOfAddress().size());

        //session.close();
        sessionFactory.close();

    }

}
