package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        Student08 student = session.get(Student08.class, 1001);
//        System.out.println(student.getBookList()); // 2 sorgu

        Book08 book = session.get(Book08.class,101);
        System.out.println(book.getStudents());


        tx.commit();
        session.close();
        sf.close();
    }
}






















