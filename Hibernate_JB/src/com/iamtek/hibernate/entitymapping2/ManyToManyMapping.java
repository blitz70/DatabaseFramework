package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails6;
import com.iamtek.hibernate.entitymapping2.dto.UserDetails7;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle6;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle7;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyMapping {

    public static void main(String[] args) {

        UserDetails7 user = new UserDetails7();
        user.setUserName("First User");

        Vehicle7 vehicle1 = new Vehicle7();
        vehicle1.setVehicleName("Car");

        Vehicle7 vehicle2 = new Vehicle7();
        vehicle2.setVehicleName("Jeep");

        //Bidirectional mapping
        user.getVehicleList().add(vehicle1);
        user.getVehicleList().add(vehicle2);
        vehicle1.getUserList().add(user);
        vehicle2.getUserList().add(user);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails7.class).addAnnotatedClass(Vehicle7.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle1);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

    }

}
