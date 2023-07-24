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

//            Employee employee1 = new Employee("Aleh", "Perepelkin", 540);
//            Employee employee2 = new Employee("Igor", "Vladov", 1020);
//
//            Department department = new Department("SALE", 1500, 300);
            Employee employee = session.get(Employee.class, 3);
            session.delete(employee);

//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            session.d();
            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
