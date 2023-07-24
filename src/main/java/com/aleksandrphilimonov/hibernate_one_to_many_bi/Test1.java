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

            Department department = new Department("IT", 1320, 300);
            Employee emp1 = new Employee("Aleksandr", "Philimonov", 500);
            Employee emp2 = new Employee("Helena", "Kotova", 1200);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

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
