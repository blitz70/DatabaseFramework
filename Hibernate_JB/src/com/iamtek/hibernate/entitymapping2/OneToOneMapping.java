package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails4;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

    public static void main(String[] args) {

        UserDetails4 user = new UserDetails4();
        Vehicle vehicle = new Vehicle();

        user.setUserName("First User");
        user.setVehicle(vehicle);
        vehicle.setVehicleName("Car");

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails4.class).addAnnotatedClass(Vehicle.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();

    }

}
