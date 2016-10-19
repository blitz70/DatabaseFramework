package com.iamtek.hibernate.com.iamtek.hibernate.demo;

import com.iamtek.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

            //start a transaction
            session.beginTransaction();

            //query & display all students
            List theStudents = session.createQuery("from Student").list();
            displayStudents(theStudents, "All students");

            //lastName='Doe'
            List theStudents2 = session.createQuery("from Student s where s.lastName='Doe'").list();
            displayStudents(theStudents2, "Students with lastname=Doe");

            //lastName='Doe' OR firstName='Daffy'
            List theStudents3 = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();
            displayStudents(theStudents3, "Students with lastName=Doe OR firstName=Daffy");

            //email ending with @luv2code.com
            List theStudents4 = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
            displayStudents(theStudents4, "Students with email ending with %gmail.com");

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

    private static void displayStudents(List theStudents, String str) {
        System.out.println("\n"+str);
        for (Object student : theStudents) {
            System.out.println(student);
        }
    }

}
