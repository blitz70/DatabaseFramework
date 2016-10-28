package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails3;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMapping {

    public static void main(String[] args) {

        UserDetails3 user = new UserDetails3();
        user.setUserName("First User");

        Vehicle3 vehicle1 = new Vehicle3();
        vehicle1.setVehicleName("Car");

        Vehicle3 vehicle2 = new Vehicle3();
        vehicle2.setVehicleName("Jeep");

        //Bidirectional mapping
        user.getVehicle().add(vehicle1);
        user.getVehicle().add(vehicle2);
        //vehicle1.setUser(user);
        //vehicle2.setUser(user);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails3.class).addAnnotatedClass(Vehicle3.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle1);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

    }

}
