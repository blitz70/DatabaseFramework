package com.iamtek.hibernate.inheritance;

import com.iamtek.hibernate.inheritance.dto.FourWheeler2;
import com.iamtek.hibernate.inheritance.dto.TwoWheeler2;
import com.iamtek.hibernate.inheritance.dto.Vehicle2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TablePerClass {

    public static void main(String[] args) {

        Vehicle2 vehicle = new Vehicle2();
        vehicle.setVehicleName("Vehicle");

        TwoWheeler2 bike = new TwoWheeler2();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheeler2 car = new FourWheeler2();
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
