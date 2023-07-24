package com.aleksandrphilimonov.hibernate_one_to_many_uni;

import com.aleksandrphilimonov.hibernate_one_to_many_uni.entity.*;
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

            Employee employee1 = new Employee("Helga", "Triniry", 780);
            Employee employee2 = new Employee("Robert", "Shelbi", 540);
            session.beginTransaction();
            Department department = session.get(Department.class, 2);
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);
            session.save(department);

            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
