package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails6;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle6;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Cascade {

    public static void main(String[] args) {

        UserDetails6 user = new UserDetails6();
        user.setUserName("First User");

        Vehicle6 vehicle1 = new Vehicle6();
        vehicle1.setVehicleName("Car");

        Vehicle6 vehicle2 = new Vehicle6();
        vehicle2.setVehicleName("Jeep");

        user.getVehicleList().add(vehicle1);
        user.getVehicleList().add(vehicle2);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails6.class).addAnnotatedClass(Vehicle6.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        //session.save(user);
        /* not needed
        session.save(vehicle1);
        session.save(vehicle2);
        */
        session.getTransaction().commit();
        session.close();

    }

}
