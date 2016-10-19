package com.iamtek.hibernate.com.iamtek.hibernate.demo;

import com.iamtek.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

            //start a transaction
            session.beginTransaction();
            int studentId = 1;

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: "+studentId);
            Student myStudent = session.get(Student.class, studentId);

            //update student
            System.out.println("Updating student");
            myStudent.setFirstName("Scooby");

            //update students
            System.out.println("Updating email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Saving error !");
        } finally {
            factory.close();
        }
    }

}
