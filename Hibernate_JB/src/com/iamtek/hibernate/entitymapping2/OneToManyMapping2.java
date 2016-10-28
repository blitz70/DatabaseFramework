package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails4;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMapping2 {

    public static void main(String[] args) {

        UserDetails4 user = new UserDetails4();
        user.setUserName("First User");

        Vehicle4 vehicle1 = new Vehicle4();
        vehicle1.setVehicleName("Car");

        Vehicle4 vehicle2 = new Vehicle4();
        vehicle2.setVehicleName("Jeep");

        //Bidirectional mapping
        user.getVehicle().add(vehicle1);
        user.getVehicle().add(vehicle1);
        user.getVehicle().add(vehicle2);
        vehicle1.setUser(user);
        vehicle2.setUser(user);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails4.class).addAnnotatedClass(Vehicle4.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle1);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

    }

}
