package com.aleksandrphilimonov.hibernate_test;

import com.aleksandrphilimonov.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

           session.createQuery("update Employee set salary=10000 " +
                   "where name = 'Zaur'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!!");
        } finally {
            factory.close();
        }

    }
}
