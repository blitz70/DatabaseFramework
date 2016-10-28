package com.iamtek.hibernate.inheritance;

import com.iamtek.hibernate.inheritance.dto.FourWheeler3;
import com.iamtek.hibernate.inheritance.dto.TwoWheeler3;
import com.iamtek.hibernate.inheritance.dto.Vehicle3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Joined {

    public static void main(String[] args) {

        Vehicle3 vehicle = new Vehicle3();
        vehicle.setVehicleName("Vehicle");

        TwoWheeler3 bike = new TwoWheeler3();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheeler3 car = new FourWheeler3();
        car.setVehicleName("Car");
        car.setSteeringWheel("Car Steering Wheel");

        SessionFactory sessionFactory = new Configuration().configure("/com/iamtek/hibernate/inheritance/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(vehicle);
        session.save(bike);
        session.save(car);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }

}
