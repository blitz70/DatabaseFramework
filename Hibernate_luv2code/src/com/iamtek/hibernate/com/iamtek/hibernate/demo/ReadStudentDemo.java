package com.iamtek.hibernate.com.iamtek.hibernate.demo;

import com.iamtek.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            //create student object
            System.out.println("Creating new student object");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            //find out saved student's id: primary key
            System.out.println("Saved student's generated id: "+tempStudent.getId());

            //get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: "+tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " +myStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

            //top is same as below
            session = factory.getCurrentSession();
            Student tempStudent2 = new Student("Daffy2", "Duck2", "daffy2@luv2code.com");
            session.beginTransaction();
            System.out.println("\n"+tempStudent2);
            session.save(tempStudent2);
            System.out.println(tempStudent2);
            Student myStudent2 = session.get(Student.class, tempStudent2.getId());
            System.out.println(myStudent2);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Saving error !");
        } finally {
            factory.close();
        }
    }

}
