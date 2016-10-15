package com.iamtek.hibernate.com.iamtek.hibernate.demo;

import com.iamtek.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            //delete student
            /*System.out.println("Deleting student" + myStudent);
            session.delete(myStudent);*/

            //update students
            System.out.println("Delete student with id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

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
