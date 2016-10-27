package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails5;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMapping {

    public static void main(String[] args) {

        UserDetails5 user = new UserDetails5();
        user.setUserName("First User");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        //Bidirectional mapping
        user.getVehicle().add(vehicle1);
        user.getVehicle().add(vehicle2);
        vehicle1.setUser(user);
        vehicle2.setUser(user);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails5.class).addAnnotatedClass(Vehicle.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle1);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

    }

}
