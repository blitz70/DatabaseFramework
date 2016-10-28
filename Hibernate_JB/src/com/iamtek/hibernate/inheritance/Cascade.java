package com.iamtek.hibernate.inheritance;

import com.iamtek.hibernate.inheritance.dto.UserDetails;
import com.iamtek.hibernate.inheritance.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Cascade {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        user.getVehicleList().add(vehicle1);
        user.getVehicleList().add(vehicle2);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails.class).addAnnotatedClass(Vehicle.class).buildSessionFactory();
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
