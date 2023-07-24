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

            Department department = new Department("HR", 5000, 50);
            Employee employee = new Employee("Maksim", "Bobrow", 540);

            department.addEmployeeToDepartment(employee);
            session.beginTransaction();
            session.save(department);

            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
