package com.aleksandrphilimonov.hibernate_one_to_many_bi;

import com.aleksandrphilimonov.hibernate_one_to_many_bi.entity.Department;
import com.aleksandrphilimonov.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println("-----------------------------------");
            System.out.println(employee.getDepartment());
            System.out.println("-----------------------------------");


            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
