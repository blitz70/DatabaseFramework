package com.iamtek.hibernate.inheritance;

import com.iamtek.hibernate.inheritance.dto.FourWheeler1;
import com.iamtek.hibernate.inheritance.dto.TwoWheeler1;
import com.iamtek.hibernate.inheritance.dto.Vehicle1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTable {

    public static void main(String[] args) {

        Vehicle1 vehicle = new Vehicle1();
        vehicle.setVehicleName("Vehicle");

        TwoWheeler1 bike = new TwoWheeler1();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheeler1 car = new FourWheeler1();
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
