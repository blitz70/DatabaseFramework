package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails2;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

    public static void main(String[] args) {

        UserDetails2 user = new UserDetails2();
        Vehicle2 vehicle = new Vehicle2();

        user.setUserName("First User");
        user.setVehicle(vehicle);
        vehicle.setVehicleName("Car");

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails2.class).addAnnotatedClass(Vehicle2.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();

    }

}
